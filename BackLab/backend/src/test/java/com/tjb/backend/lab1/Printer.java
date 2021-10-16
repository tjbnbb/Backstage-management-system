package com.tjb.backend.lab1;

import com.tjb.backend.bean.UsersBean;
import com.tjb.backend.bean.PersonBean;
import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Printer {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonMapper personMapper;

    public static Printer printer;

    @PostConstruct
    public void init() {
        printer = this;
        printer.usersMapper = this.usersMapper;
        printer.personMapper = this.personMapper;
    }

    public void PrintUsers() {
        List<UsersBean> users = printer.usersMapper.getAllUsers();
        System.out.println("\n表users：");
        System.out.println("+===============================================+");
        System.out.format("|%-20s\t|%-20s\t|\n","username","pass");
        System.out.println("+===============================================+");
        for(UsersBean usersBean:users) {
            System.out.format("|%-20s\t|%-20s\t|\n",usersBean.getusername(),usersBean.getpass());
            System.out.println("-------------------------------------------------");
        }
    }

    public void PrintPerson() {
        List<PersonBean> person = printer.personMapper.getAllPerson();
        System.out.println("\n表person：");
        System.out.println("+===============================================" +
                "================================================+");
        System.out.format("|%-20s\t|%-20s\t|%-20s\t|%-20s\t|\n","username","name","age","teleno");
        System.out.println("+===============================================" +
                "================================================+");
        for(PersonBean personBean:person) {
            System.out.format("|%-20s\t|%-20s\t|%-20s\t|%-20s\t|\n",
                    personBean.getUsername(),personBean.getName(),personBean.getAge(),personBean.getTeleno());
            System.out.println("------------------------------------------------" +
                    "-------------------------------------------------");
        }
    }
}
