package com.example.demo.Component;

import com.example.demo.ZCW.Instructor;
import com.example.demo.ZCW.Student;
import com.example.demo.ZCW.Students;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlumniTest {

    @Autowired
    Alumni alumni;

    @Test
    public void testTotalHours(){
        //Given
        Double expected = 1200.0;
        List<Student> studentList = alumni.getStudents().findAll();
        //Then
        studentList.forEach(student -> Assert.assertEquals(expected, student.getTotalStudyTime()));
    }

    @Test
    public void testHoursInstructors(){
        Double expected = 5200.0;
        List<Instructor> instructorList = alumni.getInstructors().findAll();
        //Then
        instructorList.forEach(instructor -> Assert.assertEquals(expected, instructor.getHoursTaught()));
    }

}