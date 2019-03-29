package com.example.demo.Config;

import com.example.demo.ZCW.Student;
import com.example.demo.ZCW.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    private String[] currentStudentsNames = {"Swapna", "Davis", "Julian", "Thao", "Mark", "Katherine",
            "Neela", "Sean M.", "Will", "Delenda", "Joe", "Ashley B.",
            "Laxmi", "Yang", "Aswathy", "Swarthi", "Shuchi", "Cara",
            "Reese", "Sravani", "Eric", "Alex","Ashley", "Brian", "David", "Ashley R.", "Eleanor",
            "Leah", "Nirmala", "Kyle", "Charlie", "Marlys", "Marshilla",
            "Ajah", "James", "Mike", "Robyn", "Francisco", "Sean R.", "Sunhyun"};

    private String[] previousStudentsNames = {"Khalil", "Kevin", "Ned", "Demetrius", "Andrea", "Ray",
            "Eugene", "Allison", "Brandon", "Jon", "Sean", "Connor",
            "Jenn", "Veronica", "Frankie", "Simran", "Chad", "Rachelle",
            "Nafis", "Vince", "April", "Michelle", "Jess", "Xzavia", "Ryan", "Vinny Vero"};

    @Bean
    //@Primary
    @Qualifier("currentStudents")
    public Students currentStudents() {
        return getStudents(currentStudentsNames);
    }


    @Bean
    @Qualifier("previousStudents")
    public Students previousStudents() {
        return getStudents(previousStudentsNames);
    }


    private Students getStudents(String[] currentStudentsNames) {
        Long id = 0L;
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < currentStudentsNames.length; i++) {
            Student student = new Student(id, currentStudentsNames[i]);
            id++;
            studentList.add(student);
        }
        Students students = new Students(studentList);
        return students;
    }


}
