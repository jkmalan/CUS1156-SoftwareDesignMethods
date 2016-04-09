package com.jkmalan.Project1.Version2;

/**
 This program simulates an airline reservation system.
 This is the main driver, which simply kicks off the rest of the system
 */
public class ReservationDriver
{
    public static void main(String[] args)
    {
        ReservationSystem system = new ReservationSystem();
        ReservationMenu menu = new ReservationMenu();
        menu.run(system);
    }
}