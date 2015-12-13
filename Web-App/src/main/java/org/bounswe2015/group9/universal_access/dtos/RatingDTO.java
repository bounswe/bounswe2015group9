package org.bounswe2015.group9.universal_access.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.entities.Rating;

/**
 * Created by umut on 07.12.2015.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class RatingDTO {
    private Boolean score;

    public RatingDTO(){

    }

    public RatingDTO(Boolean score) {
        this.score = score;
    }

    public RatingDTO(Rating rating){
        this.score=rating.getScore();
    }


    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }
}
