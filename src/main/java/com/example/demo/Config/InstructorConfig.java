package com.example.demo.Config;


import com.example.demo.ZCW.Instructor;
import com.example.demo.ZCW.Instructors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InstructorConfig {

    private String[] usInstructor = {"Billy", "Bob", "Tiffany", "Joel"};
    private String[] ukInstructor = {"Casey", "Anthony", "Ted", "Bundy", "Leroy", "JENKINSSSS"};
    private String[] zcwINstructors = {"Leon", "Froilan", "Dolio", "Wil", "Nhu", "Kris"};

    @Bean
    @Qualifier("Tech Connect USA instructors")
    public Instructors tcUsaInstructors() {
        return getInstructors(usInstructor);
    }

    @Bean
    @Qualifier("Tech Connect UK instructors")
    public Instructors tcUkInstructors() {
        return getInstructors(ukInstructor);
    }

    @Bean
    @Primary
    public Instructors instructors() {
        return getInstructors(zcwINstructors);
    }

    private Instructors getInstructors(String[] instructors) {
        Long id = 0L;
        List<Instructor> instructorList = new ArrayList<>();
        for (int i = 0; i < instructors.length; i++) {
            Instructor instructor = new Instructor(id, instructors[i]);
            id++;
            instructorList.add(instructor);
        }
        Instructors instructorsOne = new Instructors(instructorList);
        return instructorsOne;
    }


}
