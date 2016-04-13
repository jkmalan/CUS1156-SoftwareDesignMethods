package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class LoggerDriver {

    public static void main(String[] args) {
        try {
            SimpleLogger logger = LoggerFactory.getLogger("File");
            logger.setFormatter(new PlainFormatter());
            logger.setLevel(LoggerLevel.WARNING);

            logger.log(LoggerLevel.INFO, "main()", "initializing system");
            logger.log(LoggerLevel.INFO, "main()", "useless system test");
            logger.log(LoggerLevel.INFO, "main()", "initializing system complete");
        } catch (LoggerException ex) {
            ex.printStackTrace();
        }
    }

}
