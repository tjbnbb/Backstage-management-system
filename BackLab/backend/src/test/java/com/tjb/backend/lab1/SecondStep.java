package com.tjb.backend.lab1;

import com.tjb.backend.bean.PersonBean;
import com.tjb.backend.bean.UsersBean;
import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SecondStep {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private Printer printer;

    public static SecondStep secondStep;

    @PostConstruct
    public void init() {
        secondStep = this;
        secondStep.usersMapper = this.usersMapper;
        secondStep.personMapper = this.personMapper;
        secondStep.printer = this.printer;
    }

    public void Second() {
        secondStep.usersMapper.insertUsers(new UsersBean("ly","123456"));
        secondStep.usersMapper.insertUsers(new UsersBean("liming","345678"));
        secondStep.usersMapper.insertUsers(new UsersBean("test","11111"));
        secondStep.usersMapper.insertUsers(new UsersBean("test1","12345"));
        secondStep.personMapper.insertPerson(new PersonBean("test1","12345",null,""));
        secondStep.personMapper.insertPerson(new PersonBean("liming","李明",25,""));
        secondStep.personMapper.insertPerson(new PersonBean("test","测试用户",20,"13388449933"));
        System.out.println("\n执行第二步：");
        secondStep.printer.PrintUsers();
        secondStep.printer.PrintPerson();
    }
}