package com.sweng.universalaccess;

/**
 * Created by burakcoskun on 12/12/15.
 */
public class Violation {

    private String title;
    private String description;

    private String city,district,neighborhood,type;
    private int severityRate;
    private boolean isClosed;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


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

}
