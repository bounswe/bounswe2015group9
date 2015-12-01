package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "violation")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Violation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    @Type(type = "text")
    private String description;

    @Column(name = "date", nullable = true)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    @Column(name = "severity_rate", nullable = false)
    private Integer severityRate;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Column(name = "location", nullable = true)
    private String location;

    @Column(name = "closed", nullable = false)
    private Boolean closed;

    public Violation(ViolationDTO violationDTO, User user) {
        id = violationDTO.getId();
        title = violationDTO.getTitle();
        description = violationDTO.getDescription();
        date = violationDTO.getDate();
        severityRate = violationDTO.getSeverityRate();
        imageUrl = violationDTO.getImageUrl();
        location = violationDTO.getLocation();
        closed = violationDTO.getClosed();
        this.user = user;
    }

    public Violation() {
    }

    public Violation(User user, String title, String description, DateTime date, Integer severityRate, String imageUrl, String location, Boolean active, Boolean closed) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.date = date;
        this.severityRate = severityRate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeverityRate() {
        return severityRate;
    }

    public void setSeverityRate(Integer severityRate) {
        this.severityRate = severityRate;
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
}
