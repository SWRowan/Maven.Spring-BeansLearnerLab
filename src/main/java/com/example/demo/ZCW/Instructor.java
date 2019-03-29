package com.example.demo.ZCW;

import com.example.demo.Interfaces.Learner;
import com.example.demo.Interfaces.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person implements Teacher {
    private Double hoursTaught = 0.0;

    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, Double numOfHours) {
        learner.learn(numOfHours);

    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, Double numOfHours) {
        List<Learner> learnerList = new ArrayList<>();
        learners.forEach(learner -> learnerList.add(learner));
         for (Learner learner : learnerList){
             teach(learner, numOfHours);
         }
    }

    public Double getHoursTaught() {
        return hoursTaught;
    }

    public void setHoursTaught(Double hoursTaught) {
        this.hoursTaught = hoursTaught;
    }
}
