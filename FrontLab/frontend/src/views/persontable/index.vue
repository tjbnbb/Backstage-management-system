<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.username" placeholder="Username" style="width: 250px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <el-select v-model="listQuery.type" placeholder="Type" clearable style="width: 120px" class="filter-item">
        <el-option v-for="item in typeOption" :key="item" :label="item" :value="item" />
      </el-select>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        Search
      </el-button>
      <el-button class="filter-item" style="margin-left: 20px;" type="primary" icon="el-icon-edit" @click="handleCreate">
        Add
      </el-button>
    </div>

    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      style="width: 100%;"
    >
      <el-table-column align="center" label="username" width="250">
        <template slot-scope="scope">
          <span>{{ scope.row.username }}</span>
        </template>
      </el-table-column>
      <el-table-column label="name" width="500" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="age" width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.age }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="teleno" width="250">
        <template slot-scope="scope">
          <span>{{ scope.row.teleno }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Actions" align="center" min-width="150" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">
            Edit
          </el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="fetchData" />

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="Username" prop="username">
          <el-input v-model="temp.username" :disabled="edit" placeholder="Please input username" />
        </el-form-item>
        <el-form-item label="Name" prop="name">
          <el-input v-model="temp.name" placeholder="Please input name" />
        </el-form-item>
        <el-form-item label="Age" prop="age">
          <el-input v-model="temp.age" placeholder="Please input age" />
        </el-form-item>
        <el-form-item label="Teleno" prop="teleno">
          <el-input v-model="temp.teleno" placeholder="Please input teleno" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          Cancel
        </el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">
          Confirm
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getPageInfo, deletePerson, updatePerson, insertPerson } from '@/api/persontable'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination
import waves from '@/directive/waves' // waves directive

export default {
  components: { Pagination },
  directives: { waves },
  data() {
    return {
      list: null,
      listLoading: true,
      total: 0,
      listQuery: {
        page: 1,
        limit: 5,
        username: undefined,
        type: undefined
      },
      typeOption: ['exact', 'fuzzy'],
      temp: {
        username: '',
        name: '',
        age: undefined,
        teleno: undefined
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: 'Edit',
        create: 'Create'
      },
      edit: 'false',
      rules: {
        username: [{ required: true, message: 'username is required', trigger: 'blur' },
          { max: 10, message: 'Can not input over 10 characters', trigger: 'blur' }],
        name: [{ required: true, message: 'name is required', trigger: 'blur' },
          { max: 20, message: 'Can not input over 20 characters', trigger: 'blur' }],
        age: [
          { type: 'number', required: false, message: 'age must be a numeric value', transform(value) { return Number(value) } },
          { type: 'number', min: 0, max: 150, message: 'Please ensure that the input age is between 0～150', transform(value) { return Number(value) }, trigger: 'blur' }
        ],
        teleno: [
          { type: 'number', required: false, message: 'teleno must be a numeric value', transform(value) { return Number(value) } },
          { type: 'number', min: 0, max: 99999999999, message: 'Please ensure that the number of telephone digits does not exceed 11', transform(value) { return Number(value) }, trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getPageInfo(this.listQuery).then(response => {
        this.list = response.data.list
        this.total = response.data.total
        this.listLoading = false
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.fetchData()
    },
    handleDelete(row) {
      this.$confirm('This operation will permanently delete this piece of data, do you want to continue?', 'warning', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        deletePerson(row.username).then(() => {
          this.$notify({
            title: 'Success',
            message: 'Delete Successfully',
            type: 'success',
            duration: 2000
          })
          this.fetchData()
        })
      })
    },
    resetTemp() {
      this.temp = {
        username: '',
        name: '',
        age: undefined,
        teleno: undefined
      }
    },
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.edit = false
      this.temp.age = null
      this.temp.teleno = ''
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createData() {
      this.$confirm('If there is no corresponding users, an initial users will be created, do you want to continue?', 'warning', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            const tempData = Object.assign({}, this.temp)
            insertPerson(tempData).then(() => {
              this.dialogFormVisible = false
              this.$notify({
                title: 'Success',
                message: 'Update Successfully',
                type: 'success',
                duration: 2000
              })
              this.fetchData()
            })
          }
        })
      })
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.edit = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$confirm('This operation will permanently modify this piece of data, do you want to continue?', 'warning', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            const tempData = Object.assign({}, this.temp)
            updatePerson(tempData).then(() => {
              this.dialogFormVisible = false
              this.$notify({
                title: 'Success',
                message: 'Update Successfully',
                type: 'success',
                duration: 2000
              })
              this.fetchData()
            })
          }
        })
      })
    }
  }
}
</script>
