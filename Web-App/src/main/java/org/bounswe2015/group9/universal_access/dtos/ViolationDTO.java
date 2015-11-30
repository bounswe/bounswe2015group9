package org.bounswe2015.group9.universal_access.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.bounswe2015.group9.universal_access.utils.JsonDTOFilter;


import java.beans.Transient;
import java.io.Serializable;

//@JsonFilter(JsonDTOFilter.USERDTOFILTER)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ViolationDTO {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private Long ownerId;
    private Long severityRate;
    private String imageUrl;
    private String location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId){
        this.ownerId = ownerId;
    }



    public void setSeverityRate(Long severity_rate){
        this.severityRate = severity_rate;
    }


    public Long getSeverityRate() {
        return severityRate;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }



    public ViolationDTO(Long id, String title, String description, String ownerName,
         Long ownerId , Long severityRate, String imageUrl,String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.severityRate = severityRate;
        this.imageUrl = imageUrl ;
        this.location = location ; 
    }

    public ViolationDTO() {

    }

    public ViolationDTO(Violation violation) {
        id = violation.getId();
        title = violation.getTitle();
        description = violation.getDescription();
        ownerName = violation.getOwner_name();
        ownerId = violation.getOwner_id();
        severityRate = violation.getSeverety_rate();
        imageUrl = violation.getImage_url();
        location = violation.getLocation();
    }
}
