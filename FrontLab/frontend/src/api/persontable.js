import request from '@/utils/request'

export function getPersonList(params) {
  return request({
    url: '/person/getallperson',
    method: 'get',
    params
  })
}

export function getPageInfo(params) {
  return request({
    url: '/person/getPageInfo',
    method: 'get',
    params: params
  })
}

export function deletePerson(username) {
  return request({
    url: '/person/deleteperson?username=' + username,
    method: 'delete'
  })
}

export function updatePerson(personBean) {
  return request({
    url: '/person/updateperson',
    method: 'put',
    data: personBean
  })
}

export function insertPerson(personBean) {
  return request({
    url: '/person/insertperson',
    method: 'post',
    data: personBean
  })
}
