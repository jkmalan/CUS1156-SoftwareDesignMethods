package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public enum LoggerLevel {

    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    SEVERE(4);

    private int value;

    private LoggerLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean permitsLogging(LoggerLevel level) {
        boolean result = false;
        if (value <= level.getValue()) {
            result = true;
        }
        return result;
    }

    public String toString() {
        String str;
        switch (value) {
            case 0 :
                str = "DEBUG";
                break;
            case 1 :
                str = "INFO";
                break;
            case 2 :
                str = "WARNING";
                break;
            case 3 :
                str = "ERROR";
                break;
            case 4 :
                str = "SEVERE";
                break;
            default :
                str = "";
        }
        return str;
    }

}
