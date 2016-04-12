package com.jkmalan.Lab9.Registration;

public class FreshmanCenter {

    public void doScheduling() {
        Registration reg = Registration.getInstance();

        // register some students
        reg.register("CUS1115");
        reg.register("CUS1115");
        reg.register("CUS1116");

        // withdraw someone
        reg.withdraw("CUS1115");

        System.out.println("Freshman Center finished scheduling");
        reg.displayCourses();
    }

}
