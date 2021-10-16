package com.tjb.backend.lab1;

import com.tjb.backend.bean.PersonBean;
import com.tjb.backend.bean.UsersBean;
import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ThirdStep {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private Printer printer;

    public static ThirdStep thirdStep;

    @PostConstruct
    public void init() {
        thirdStep = this;
        thirdStep.usersMapper = this.usersMapper;
        thirdStep.personMapper = this.personMapper;
        thirdStep.printer = this.printer;
    }

    public void Third() {
        modify(new PersonBean("ly","王五",null,""));
        modify(new PersonBean("test2","测试用户 2",null,""));
        modify(new PersonBean("test1","测试用户 1",33,""));
        modify(new PersonBean("test","张三",23,"18877009966"));
        modify(new PersonBean("admin","admin",null,""));
        System.out.println("\n执行第三步：");
        thirdStep.printer.PrintUsers();
        thirdStep.printer.PrintPerson();
    }

    public void modify(PersonBean personBean) {
        String username = personBean.getUsername();
        List<UsersBean> users = thirdStep.usersMapper.getlikeUsers(username);
        List<PersonBean> person = thirdStep.personMapper.getlikePerson(username);
        if(users.isEmpty()) {
            thirdStep.usersMapper.insertUsers(new UsersBean(username,"888888"));
        }
        else {
            if(person.isEmpty()) {
                thirdStep.personMapper.insertPerson(personBean);
            }
            else {
                thirdStep.personMapper.updatePerson(personBean);
            }
        }
    }
}