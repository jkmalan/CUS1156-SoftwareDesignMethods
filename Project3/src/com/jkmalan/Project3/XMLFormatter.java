package com.jkmalan.Project3;

import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class XMLFormatter implements Formatter {

    @Override
    public String format(LoggerLevel level, String component, String msg) {
        String str = "<LogMessage>\n";

        // Appends the time, level, component, and message
        str += "  <Level>" + level.toString() + "</Level>\n";
        str += "  <DateTime>" + LocalDateTime.now().toString() + "</DateTime>\n";
        str += "  <Component>" + component + "</Component>\n";
        str += "  <Message>" + msg + "</Message>\n";

        return str + "</LogMessage>";
    }

}
