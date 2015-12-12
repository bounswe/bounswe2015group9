package com.sweng.universalaccess;

/**
 * Created by burakcoskun on 12/12/15.
 */
public class Violation {

    private String title;
    private String description;
    private int severityRate;
    private String location;
    private boolean isClosed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeverityRate() {
        return severityRate;
    }

    public void setSeverityRate(int severityRate) {
        this.severityRate = severityRate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
