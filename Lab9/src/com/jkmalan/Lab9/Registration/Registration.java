package com.jkmalan.Lab9.Registration;

import java.util.HashMap;

public class Registration {

    private static Registration INSTANCE;

    private HashMap<String, Course> courses = new HashMap<String, Course>();

    private Registration() {
        courses.put("CUS1115", new Course("CUS1115"));
        courses.put("CUS1116", new Course("CUS1116"));
        courses.put("CUS1126", new Course("CUS1126"));
        courses.put("CUS1166", new Course("CUS1166"));
        courses.put("CUS1185", new Course("CUS1185"));
    }

    public static Registration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Registration();
        }
        return INSTANCE;
    }

    public void register(String name) {
        if (courses.containsKey(name)) {
            courses.get(name).addStudent();
        }
    }

    public void withdraw(String name) {
        if (courses.containsKey(name)) {
            courses.get(name).removeStudent();
        }
    }

    public void displayCourses() {
        System.out.println(courses.values());
    }

}
