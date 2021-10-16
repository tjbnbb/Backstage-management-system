package com.tjb.backend.lab1;

import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstStep {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private Printer printer;

    public static FirstStep firstStep;

    @PostConstruct
    public void init() {
        firstStep = this;
        firstStep.usersMapper = this.usersMapper;
        firstStep.personMapper = this.personMapper;
        firstStep.printer = this.printer;
    }

    public void First() {
        firstStep.usersMapper.dropUserstable();
        firstStep.personMapper.dropPersontable();
        firstStep.usersMapper.createUserstable();
        firstStep.personMapper.createPersontable();
        System.out.println("\n执行第一步：");
        firstStep.printer.PrintUsers();
        firstStep.printer.PrintPerson();
    }
}