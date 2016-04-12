package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class FileLogger extends SimpleLogger {

    private static FileLogger INSTANCE;

    private FileLogger() {

    }

    public static FileLogger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileLogger();
        }
        return INSTANCE;
    }

    @Override
    public void log(LoggerLevel level, String component, String msg) throws LoggerException {

    }

    @Override
    public void log(LoggerLevel level, String component, Throwable ex) throws LoggerException {

    }

}
