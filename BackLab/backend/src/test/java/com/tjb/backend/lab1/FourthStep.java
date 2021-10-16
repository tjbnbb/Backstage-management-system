package com.tjb.backend.lab1;

import com.tjb.backend.mapper.PersonMapper;
import com.tjb.backend.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FourthStep {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private Printer printer;

    public static FourthStep fourthStep;

    @PostConstruct
    public void init() {
        fourthStep = this;
        fourthStep.usersMapper = this.usersMapper;
        fourthStep.personMapper = this.personMapper;
        fourthStep.printer = this.printer;
    }

    public void Fourth() {
        fourthStep.usersMapper.deletelikeUsers("test%");
        fourthStep.personMapper.deletelikePerson("test%");
        System.out.println("\n执行第四步：");
        fourthStep.printer.PrintUsers();
        fourthStep.printer.PrintPerson();
    }
}