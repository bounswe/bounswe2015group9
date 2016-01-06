package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true, nullable = false)
    private Long id;

    @JoinColumn(name = "name", nullable = false)
    private String name;

    private Set<Violation> violations = new HashSet<Violation>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tag_violation",
            joinColumns = { @JoinColumn(name = "tag_id") },
            inverseJoinColumns = { @JoinColumn(name = "violation_id") })
    public Set<Violation> getViolations() {
        return violations;
    }

    public Tag(){

    }

    public Tag(TagDTO tagDTO){
        this.id=tagDTO.getId();
        this.name=tagDTO.getName();
    }

    public Tag(Violation violation, TagDTO tagDTO){
        this.id=tagDTO.getId();
        this.name=tagDTO.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Tag obj2 = (Tag)obj;
        if((this.id == obj2.getId()) && (this.name.equals(obj2.getName())))
        {
            return true;
        }
        return false;
    }
    public int hashCode() {
        int tmp = 0;
        tmp = (id + name).hashCode();
        return tmp;
    }
}
