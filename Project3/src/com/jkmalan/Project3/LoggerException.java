package com.jkmalan.Project3;

import java.io.IOException;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class LoggerException extends IOException {

    public LoggerException() {

    }

    public LoggerException(String msg) {
        super(msg);
    }

    public LoggerException(Throwable ex) {
        super(ex);
    }

    public LoggerException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
