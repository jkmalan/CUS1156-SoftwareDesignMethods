package com.jkmalan.Project3;

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
    public void log(LoggerLevel level, String component, String msg) throws LoggerException {
        System.out.println(formatter.format(level, component, msg));
    }

    @Override
    public void log(LoggerLevel level, String component, Throwable ex) throws LoggerException {
        System.out.println(formatter.format(level, component, ex.getMessage()));
    }

}
