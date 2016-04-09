package com.jkmalan.Lab1;

/**
 * This class represents a single cat. A cat can be created with or without
 * initial characteristics.
 *
 * @author Bonnie MacKellar
 * @author jkmalan (aka John Malandrakis)
 *
 */
public class Cat {

    private String name;
    private String color;

    public Cat() { }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    private void meow() {
        System.out.println("Meow!");
    }

    public void manyMeows(int howMany) {
        System.out.println(name + " says ");
        int count = 0;
        while (count++ < howMany)
            meow();
    }

    public void printMyName() {
        System.out.println("my name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}