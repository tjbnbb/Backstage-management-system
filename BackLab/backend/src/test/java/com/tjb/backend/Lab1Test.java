package com.tjb.backend;

import com.tjb.backend.lab1.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Lab1Test {

    @Autowired
    FirstStep firstStep;

    @Autowired
    SecondStep secondStep;

    @Autowired
    ThirdStep thirdStep;

    @Autowired
    FourthStep fourthStep;

    @Test
    public void Lab1() {
        firstStep.First();
        secondStep.Second();
        thirdStep.Third();
        fourthStep.Fourth();
    }
}
