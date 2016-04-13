package com.jkmalan.Project3;

import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class PlainFormatter implements Formatter {

    @Override
    public String format(LoggerLevel level, String component, String msg) {
        String str = "[";

        // Appends the time, level, component, and message
        str += level.toString() + "][";
        str += LocalDateTime.now().toString() + "]";
        str += component + ": ";
        str += msg;

        return str;
    }

}
