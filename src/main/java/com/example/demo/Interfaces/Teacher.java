package com.example.demo.Interfaces;

public interface Teacher {

    void teach(Learner learner, Double numOfHours);
    void lecture(Iterable<? extends Learner> learners, Double numOfHours);

}
