package com.tjb.backend.servicelmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjb.backend.bean.PersonBean;
import com.tjb.backend.bean.UsersBean;
import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import com.tjb.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServicelmpl implements PersonService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    PersonMapper personMapper;

    @Override
    public int createPersontable() {
        return personMapper.createPersontable();
    }

    @Override
    public int insertPerson(PersonBean personBean) {
        if((usersMapper.getlikeUsers(personBean.getUsername())).isEmpty()) {
            usersMapper.insertUsers(new UsersBean(personBean.getUsername(),"888888"));
        }
        return personMapper.insertPerson(personBean);
    }

    @Override
    public int deletePerson(String usersname) {
        return personMapper.deletelikePerson(usersname);
    }

    @Override
    public int deletebeginPerson(String usersname) {
        return personMapper.deletelikePerson(usersname + "%");
    }

    @Override
    public int updatePerson(PersonBean personBean) {
        return personMapper.updatePerson(personBean);
    }

    @Override
    public List<PersonBean> getPerson(String usersname) {
        return personMapper.getlikePerson(usersname);
    }

    @Override
    public List<PersonBean> getlikePerson(String usersname) {
        return personMapper.getlikePerson("%" + usersname + "%");
    }

    @Override
    public List<PersonBean> getAllPerson() {
        return personMapper.getAllPerson();
    }

    @Override
    //分页查询
    public PageInfo<PersonBean> getPageInfo(int page, int limit, String username, String type) {
        PageHelper.startPage(page, limit,true);
        List<PersonBean> person;
        if(username == null || username.equals("") || type == null || type.equals("")) person = personMapper.getAllPerson();
        else if(type.equals("exact")) person = personMapper.getlikePerson(username);
        else person = personMapper.getlikePerson("%" + username + "%");
        return new PageInfo<>(person);
    }

    @Override
    public int dropPersontable() {
        return personMapper.dropPersontable();
    }

}
