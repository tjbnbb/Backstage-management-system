package com.tjb.backend.service;

import com.github.pagehelper.PageInfo;
import com.tjb.backend.bean.PersonBean;

import java.util.List;

public interface PersonService {

    int createPersontable();

    int insertPerson(PersonBean personBean);

    int deletePerson(String usersname);

    int deletebeginPerson(String usersname);

    int updatePerson(PersonBean personBean);

    List<PersonBean> getPerson(String usersname);

    List<PersonBean> getlikePerson(String usersname);

    List<PersonBean> getAllPerson();

    //分页查询
    PageInfo<PersonBean> getPageInfo(int page, int limit, String username, String type);

    int dropPersontable();

}
