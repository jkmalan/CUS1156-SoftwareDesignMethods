package com.jkmalan.Project3;

import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class XMLFormatter implements Formatter {

    @Override
    public String format(LogMessage logMessage) {
        String str = "<LogMessage>\n";

        // Appends the time, level, component, and message
        str += "  <Level>" + logMessage.getLevel().toString() + "</Level>\n";
        str += "  <DateTime>" + logMessage.getTime().toString() + "</DateTime>\n";
        str += "  <Component>" + logMessage.getComponent() + "</Component>\n";
        str += "  <Message>" + logMessage.getMessage() + "</Message>\n";

        return str + "</LogMessage>";
    }

}
