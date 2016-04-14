package com.jkmalan.Project3;

import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class PlainFormatter implements Formatter {

    @Override
    public String format(LogMessage logMessage) {
        String str = "[";

        // Appends the time, level, component, and message
        str += logMessage.getLevel().toString() + "][";
        str += logMessage.getTime().toString() + "]";
        str += logMessage.getComponent() + ": ";
        str += logMessage.getMessage();

        return str;
    }

}
