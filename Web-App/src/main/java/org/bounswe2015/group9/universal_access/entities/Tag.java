package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;
<<<<<<< HEAD

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
=======
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;

import javax.persistence.*;
import java.io.Serializable;
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9

/**
 * Created by umut on 12.12.2015.
 */
@Entity
@Table(name = "tag")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Tag implements Serializable{
    private static final long serialVersionUID = 1L;
<<<<<<< HEAD

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


=======
    @Id
    @JoinColumn(name = "name", nullable = false)
    private String name;

    @Id
//    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "violation_id", nullable = true)
    private Violation violation;
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9

    public Tag(){

    }

<<<<<<< HEAD
    public Tag(TagDTO tagDTO){
        this.id=tagDTO.getId();
        this.name=tagDTO.getName();
    }

    public Tag(Violation violation, TagDTO tagDTO){
        this.id=tagDTO.getId();
        this.name=tagDTO.getName();
//        this.violations=getViolations();
=======
    public Tag(Violation violation, TagDTO tagDTO){
        this.name=tagDTO.getName();
        this.violation=violation;
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD

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
        tmp = ( id + name ).hashCode();
        return tmp;
=======
    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
    }
}
