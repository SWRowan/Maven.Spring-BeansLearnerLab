package com.example.demo.Config;

import com.example.demo.ZCW.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;


@Configuration
public class ClassroomConfig {

    @Autowired
    StudentConfig studentConfig;
    @Autowired
    InstructorConfig instructorConfig;

    @Bean
    @Qualifier("currentCohort")
    //@DependsOn({"instructors", "currentStudents"})
    public Classroom currentCohort(){
        Classroom classroom = new Classroom(instructorConfig.instructors(), studentConfig.currentStudents());
        return classroom;
    }

    @Bean
    @Qualifier("previousCohort")
    //@DependsOn({"instructors", "previousStudents"})
    public Classroom previousCohort(){
        Classroom classroom = new Classroom(instructorConfig.instructors(), studentConfig.previousStudents());
        return classroom;
    }
}
