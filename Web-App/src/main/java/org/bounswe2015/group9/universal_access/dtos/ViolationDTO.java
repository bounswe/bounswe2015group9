package org.bounswe2015.group9.universal_access.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.joda.time.DateTime;

import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ViolationDTO {
    private Long id;
    private String title;
    private String description;
    private DateTime date;
    private DateTime modificationDate;
    private String imageUrl;
    private String location;
    private Boolean closed;
    private UserDTO user;

    public ViolationDTO(Violation violation) {
        id = violation.getId();
        title = violation.getTitle();
        description = violation.getDescription();
        date = violation.getDate();
        modificationDate = violation.getModificationDate();
        imageUrl = violation.getImageUrl();
        location = violation.getLocation();
        closed = violation.getClosed();
        user = new UserDTO(violation.getUser());
        user.setPassword(null);
    }

    public ViolationDTO() {
    }

    public ViolationDTO(Long id, String title, String description, DateTime date, DateTime modificationDate, String imageUrl, String location, Boolean active, Boolean closed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.modificationDate = modificationDate;
        this.imageUrl = imageUrl;
        this.location = location;
        this.closed = closed;
    }

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

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public DateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(DateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
