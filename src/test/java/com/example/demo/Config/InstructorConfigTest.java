package com.example.demo.Config;

import com.example.demo.ZCW.Instructor;
import com.example.demo.ZCW.Instructors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InstructorConfigTest {
    @Autowired
    @Qualifier("Tech Connect USA instructors")
    Instructors tcUsa;

    @Test
    public void testSizeOne(){
        //Given
        int expected = 4;
        //When
        int actual = tcUsa.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContainsUsa(){
        //Given
        String[] usInstructor = {"Billy", "Bob", "Tiffany", "Joel"};
        List<String> expexted = new ArrayList<>(Arrays.asList(usInstructor));
        //When
        List<Instructor> actual = tcUsa.findAll();
        //Then
        actual.forEach(instructor -> expexted.contains(instructor.getName()));
    }

    @Autowired
    @Qualifier("Tech Connect UK instructors")
    Instructors tcUk;

    @Test
    public void testSizeTwo(){
        //Given
        int expected = 6;
        //When
        int actual = tcUk.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContainsUk(){
        //Given
        String[] ukInstructor = {"Casey", "Anthony", "Ted", "Bundy", "Leroy", "JENKINSSSS"};
        List<String> expected = new ArrayList<>(Arrays.asList(ukInstructor));
        //When
        List<Instructor> actual = tcUk.findAll();
        //Then
        actual.forEach(instructor -> expected.contains(instructor.getName()));
    }

    @Autowired
    Instructors instructors;

    @Test
    public void testSizeThree(){
        //Given
        int expected = 6;
        //When
        int actual = instructors.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContainsInstructor(){
        //Given
        String[] zcwINstructors = {"Leon", "Froilan", "Dolio", "Wil", "Nhu", "Kris", "Melanie"};
        List<String> expected = new ArrayList<>(Arrays.asList(zcwINstructors));
        //When
        List<Instructor> actual = instructors.findAll();
        //Then
        actual.forEach(instructor -> expected.contains(instructor.getName()));
    }

}