package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class LoggerDriver {

    public static void main(String[] args) {
        try {
            SimpleLogger logger = LoggerFactory.getLogger("Console");
            logger.setFormatter(new XMLFormatter());
            logger.setLevel(LogLevel.INFO);

            logger.log(LogLevel.INFO, "main()", "initializing system");
            logger.log(LogLevel.WARNING, "main()", "useless system test");
            logger.log(LogLevel.ERROR, "main()", "initializing system complete");

            try {
                String test = exceptionTest();
                char a = test.charAt(0); // Purposefully cause NullPointerException
            } catch (NullPointerException ex) {
                logger.log(LogLevel.SEVERE, "exceptionTest()", ex);
            }

            logger.log(LogLevel.INFO, "main()", "finishing program");
        } catch (LoggerException ex) {
            ex.printStackTrace();
        }
    }

    public static String exceptionTest() {
        return null;
    }

}
