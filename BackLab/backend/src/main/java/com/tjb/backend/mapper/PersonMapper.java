package com.tjb.backend.mapper;

import com.tjb.backend.bean.PersonBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    int createPersontable();

    int insertPerson(PersonBean personBean);

    int deletelikePerson(String username);

    int updatePerson(PersonBean personBean);

    List<PersonBean> getlikePerson(String usersname);

    List<PersonBean> getAllPerson();

    int dropPersontable();
}
