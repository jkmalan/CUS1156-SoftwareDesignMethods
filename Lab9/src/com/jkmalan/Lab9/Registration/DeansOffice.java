package com.jkmalan.Lab9.Registration;

public class DeansOffice {

    public void doScheduling() {
        Registration reg = Registration.getInstance();

        // register some students
        reg.register("CUS1115");
        reg.register("CUS1115");
        reg.register("CUS1126");
        reg.register("CUS1126");
        reg.register("CUS1126");
        reg.register("CUS1166");
        reg.register("CUS1166");
        reg.register("CUS1166");
        reg.register("CUS1166");
        reg.withdraw("CUS1166");
        reg.register("CUS1166");
        reg.register("CUS1166");

        // withdraw someone
        reg.withdraw("CUS1115");

        System.out.println("Dean's Office finished scheduling");
        reg.displayCourses();
    }

}
