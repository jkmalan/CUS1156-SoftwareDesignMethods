package com.jkmalan.Project3;

import java.time.LocalDateTime;

/**
 *
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class LogMessage {

    private LogLevel level;
    private LocalDateTime time;
    private String component;
    private String message;

    public LogMessage(LogLevel level, LocalDateTime time, String component, String message) {
        setLevel(level);
        setTime(time);
        setComponent(component);
        setMessage(message);
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
