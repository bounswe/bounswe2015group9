package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "violation")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Violation implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title", length = 50, nullable = false, unique = true)
    private String title;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "owner_name", length = 255, nullable = false)
    private String owner_name;

    @Column(name = "owner_id", unique = true, nullable = false)
    private Long owner_id;

    @Column(name= "severety_rate", nullable = false)
    private Long severety_rate;

    @Column(name = "image_url" , nullable = false)
    private String image_url;

    @Column(name = "location", nullable = false)
    private String location;

    public Violation() {
    }

    public Violation(ViolationDTO violationDTO) {
        id = violationDTO.getId();
        title = violationDTO.getTitle();
        description = violationDTO.getDescription();
        owner_name = violationDTO.getOwnerName();
        owner_id = violationDTO.getOwnerId();
        severety_rate = violationDTO.getSeverityRate();
        image_url = violationDTO.getImageUrl();
        location = violationDTO.getLocation();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setSeverety_rate(Long severety_rate) {
        this.severety_rate = severety_rate;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public Long getSeverety_rate() {
        return severety_rate;
    }

    public String getLocation() {
        return location;
    }

    public String getImage_url() {
        return image_url;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
