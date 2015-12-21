package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "modification_date", nullable = true)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationDate;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Column(name = "location", nullable = true)
    private String location;

    @Column(name = "closed", nullable = false)
    private Boolean closed;

    private Set<Tag> tags = new HashSet<Tag>();

    @ManyToMany(mappedBy = "tags")
    public Set<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }


    public Violation(ViolationDTO violationDTO, User user) {
        id = violationDTO.getId();
        title = violationDTO.getTitle();
        description = violationDTO.getDescription();
        date = violationDTO.getDate();
        modificationDate = violationDTO.getModificationDate();
        imageUrl = violationDTO.getImageUrl();
        location = violationDTO.getLocation();
        closed = violationDTO.getClosed();
        this.user = user;
    }
    public Violation(ViolationDTO violationDTO) {
        id = violationDTO.getId();
        title = violationDTO.getTitle();
        description = violationDTO.getDescription();
        date = violationDTO.getDate();
        modificationDate = violationDTO.getModificationDate();
        imageUrl = violationDTO.getImageUrl();
        location = violationDTO.getLocation();
        closed = violationDTO.getClosed();
    }


    public Violation() {
    }

    public Violation(User user, String title, String description, DateTime date, DateTime modificationDate, String imageUrl, String location, Boolean active, Boolean closed) {
        this.user = user;
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

}
