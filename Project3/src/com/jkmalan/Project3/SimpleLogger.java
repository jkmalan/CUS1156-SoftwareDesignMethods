package com.jkmalan.Project3;

/**
 * @author jkmalan (aka John Malandrakis)
 */
public abstract class SimpleLogger {

    protected LoggerLevel level = LoggerLevel.ERROR;
    protected Formatter formatter;

    public void setLevel(LoggerLevel level) {
        this.level = level;
    }

    public LoggerLevel getLevel() {
        return level;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public abstract void log(LoggerLevel level, String component, String msg) throws LoggerException;

    public abstract void log(LoggerLevel level, String component, Throwable ex) throws LoggerException;
}
