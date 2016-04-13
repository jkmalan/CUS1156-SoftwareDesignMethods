package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class LoggerFactory {

    public static SimpleLogger getLogger(String loggerType) {
        SimpleLogger logger;
        if (loggerType.equals("Console")) {
            logger = ConsoleLogger.getInstance();
        } else if (loggerType.equals("File")) {
            logger = FileLogger.getInstance();
        } else {
            logger = null;
        }
        return logger;
    }

}
