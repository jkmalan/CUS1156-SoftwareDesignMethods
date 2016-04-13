package com.jkmalan.Project3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        File file = new File("log.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(formatter.format(level, component, msg) + "\n");
            writer.close();
        } catch (IOException e) {
            throw new LoggerException();
        }
    }

    @Override
    public void log(LoggerLevel level, String component, Throwable ex) throws LoggerException {
        File file = new File("log.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(formatter.format(level, component, ex.getMessage()) + "\n");
            writer.close();
        } catch (IOException e) {
            throw new LoggerException();
        }
    }

}
