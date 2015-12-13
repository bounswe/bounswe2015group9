package org.bounswe2015.group9.universal_access.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.dtos.RatingDTO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by umut on 07.12.2015.
 */
@Entity
@Table(name = "rating")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Rating implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "violation_id", nullable = true)
    private Violation violation;

    @Column(name = "score", nullable = true)
    private Boolean score;

    public Rating(){

    }

    public Rating(RatingDTO ratingDTO, User user, Violation violation){
        score=ratingDTO.getScore();
        this.user=user;
        this.violation=violation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }
}
