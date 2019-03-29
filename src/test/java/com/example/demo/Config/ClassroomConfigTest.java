package com.example.demo.Config;

import com.example.demo.ZCW.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassroomConfigTest {

    @Autowired
    ClassroomConfig classroomConfig;

    @Autowired
    InstructorConfig instructors;

    @Autowired
    @Qualifier("currentStudents")
    Students currentStudents;

    @Autowired
    @Qualifier("currentCohort")
    Classroom currentCohort;

    @Test
    public void currentInstructorsTest(){

        //Given
        Instructors expected = instructors.instructors();
        //When
        Instructors actual = classroomConfig.currentCohort().getInstructors();
        //Instructors actual = currentCohort.getInstructors();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void currentStudentTest(){
        //Given
        Students expected = currentStudents;
        //When
        Students actual = classroomConfig.currentCohort().getStudents();
        //Students actual = currentCohort.getStudents();
        //Then
        Assert.assertEquals(expected, actual);

    }



    @Autowired
    @Qualifier("previousStudents")
    Students previousStudents;


    @Test
    public void testPreviousStudents(){
        //Given
        Students expected = previousStudents;

        //When
        Students actual = classroomConfig.previousCohort().getStudents();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void currentInstructorsTesttwo(){
        //Given
        Instructors expected = instructors.instructors();
        //When
        Instructors actual = classroomConfig.previousCohort().getInstructors();
        //Then
        Assert.assertEquals(expected, actual);
    }
}