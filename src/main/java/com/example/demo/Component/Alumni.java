package com.example.demo.Component;



import com.example.demo.ZCW.Instructor;
import com.example.demo.ZCW.Instructors;
import com.example.demo.ZCW.Student;
import com.example.demo.ZCW.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class Alumni {

    Students students;
    Instructors instructors;

    public Alumni(Instructors instructors, @Qualifier("previousStudents")Students students) {
        this.students = students;
        this.instructors = instructors;
    }


    public Students getStudents() {
        return students;
    }

    public Instructors getInstructors() {
        return instructors;
    }

    @PostConstruct
    public void executeBootcamp() {
        List<Student> studentList = students.findAll();
        List<Instructor> instructorList = instructors.findAll();
        studentList.forEach(student -> student.learn(1200.0));

        int numberOfInstructors = instructors.size();
        int numberOfStudents = students.size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        instructorList.forEach(instructor -> instructor.setHoursTaught(numberOfHoursPerInstructor));

    }
}
