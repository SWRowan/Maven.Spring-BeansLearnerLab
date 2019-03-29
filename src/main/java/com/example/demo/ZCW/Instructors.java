package com.example.demo.ZCW;

import java.util.Iterator;
import java.util.List;

public class Instructors<Instructor> extends People {


    public Instructors(List<Instructor> personList) {
        super(personList);
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
