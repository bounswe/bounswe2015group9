package org.bounswe2015.group9.universal_access.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.entities.Rating;

/**
 * Created by umut on 07.12.2015.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class RatingDTO {
    private Boolean score;
    private UserDTO userDTO;
    private ViolationDTO violationDTO;

    public RatingDTO(Rating rating){
        score=rating.getScore();
    }

    public RatingDTO(Boolean score) {
        this.score = score;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ViolationDTO getViolationDTO() {
        return violationDTO;
    }

    public void setViolationDTO(ViolationDTO violationDTO) {
        this.violationDTO = violationDTO;
    }
}
