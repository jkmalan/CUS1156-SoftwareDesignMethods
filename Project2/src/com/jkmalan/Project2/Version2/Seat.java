package com.jkmalan.Project2.Version2;

public class Seat implements Comparable {

    private String id;

    public Seat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String number) {
        this.id = number;
    }

    @Override
    public int compareTo(Object o) {
        Seat s = (Seat) o;

        if (getId().indexOf(0) > s.getId().indexOf(0)) {
            return 1;
        } else if (getId().indexOf(0) < s.getId().indexOf(0)) {
            return -1;
        } else {
            return 0;
        }
    }

}
