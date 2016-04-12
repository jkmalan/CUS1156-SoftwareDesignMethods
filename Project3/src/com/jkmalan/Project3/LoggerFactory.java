package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class LoggerFactory {

    public SimpleLogger getLogger(String loggerType) {
        SimpleLogger logger;
        if (loggerType.equals("File")) {
            logger = FileLogger.getInstance();
        } else {
            logger = null;
        }
        return logger;
    }

}
