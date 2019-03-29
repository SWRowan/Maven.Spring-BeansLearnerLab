package com.example.demo.ZCW;

import com.example.demo.Interfaces.Learner;

public class Student extends Person implements Learner {
    private Double totalStudyTime = 0.0;


    public Student(Long id, String name) {
        super(id, name);
    }

    @Override
    public void learn(Double numberOfHours) {
        totalStudyTime += numberOfHours;
    }

    public Double getTotalStudyTime() {
        return totalStudyTime;
    }
}
