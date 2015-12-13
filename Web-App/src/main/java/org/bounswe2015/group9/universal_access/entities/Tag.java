package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by umut on 12.12.2015.
 */
@Entity
@Table(name = "tag")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Tag implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "name", nullable = false)
    private String name;

    @Id
//    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "violation_id", nullable = true)
    private Violation violation;

    public Tag(){

    }

    public Tag(Violation violation, TagDTO tagDTO){
        this.name=tagDTO.getName();
        this.violation=violation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }
}
