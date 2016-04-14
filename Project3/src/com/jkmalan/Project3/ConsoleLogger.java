package com.jkmalan.Project3;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ConsoleLogger extends SimpleLogger {

    private static ConsoleLogger INSTANCE;

    private ConsoleLogger() {

    }

    public static ConsoleLogger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConsoleLogger();
        }
        return INSTANCE;
    }

    @Override
    public void log(LogLevel level, String component, String msg) throws LoggerException {
        if (getLevel().permitsLogging(level)) {
            String logMsg = formatter.format(new LogMessage(level, LocalDateTime.now(), component, msg));
            System.out.println(logMsg);
        }
    }

    @Override
    public void log(LogLevel level, String component, Throwable ex) throws LoggerException {
        if (getLevel().permitsLogging(level)) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            String logMsg = formatter.format(new LogMessage(level, LocalDateTime.now(), component, sw.toString().trim()));
            System.out.println(logMsg);
        }
    }

}
