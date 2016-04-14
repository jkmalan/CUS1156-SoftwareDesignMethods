package com.jkmalan.Project3;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public abstract class SimpleLogger {

    protected LogLevel level = LogLevel.ERROR;
    protected Formatter formatter;

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public abstract void log(LogLevel level, String component, String msg) throws LoggerException;

    public abstract void log(LogLevel level, String component, Throwable ex) throws LoggerException;
}
