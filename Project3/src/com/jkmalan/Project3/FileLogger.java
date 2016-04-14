package com.jkmalan.Project3;

import java.io.*;
import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class FileLogger extends SimpleLogger {

    private static FileLogger INSTANCE;

    private File file = null;

    private FileLogger() {

    }

    public static FileLogger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileLogger();
        }
        return INSTANCE;
    }

    @Override
    public void log(LogLevel level, String component, String msg) throws LoggerException {
        if (getLevel().permitsLogging(level)) {
            String logMsg = formatter.format(new LogMessage(level, LocalDateTime.now(), component, msg));
            if (file == null) {
                file = new File("log.txt");
            }

            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write(logMsg + "\n");
                writer.close();
            } catch (IOException e) {
                throw new LoggerException("Unable to write to log", e);
            }
        }
    }

    @Override
    public void log(LogLevel level, String component, Throwable ex) throws LoggerException {
        if (getLevel().permitsLogging(level)) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            String logMsg = formatter.format(new LogMessage(level, LocalDateTime.now(), component, sw.toString().trim()));
            if (file == null) {
                file = new File("log.txt");
            }

            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write(logMsg + "\n");
                writer.close();
            } catch (IOException e) {
                throw new LoggerException("Unable to write to log", e);
            }
        }
    }

}
