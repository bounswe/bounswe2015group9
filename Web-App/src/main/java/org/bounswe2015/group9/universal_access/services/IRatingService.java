package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.RatingDTO;
import org.bounswe2015.group9.universal_access.entities.Rating;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;

/**
 * Created by umut on 07.12.2015.
 */
public interface IRatingService {
    RatingDTO getRating(User user, Violation violation);
    RatingDTO setRating(User user, Violation violation, RatingDTO ratingDTO);
    RatingDTO updateRating(Rating rating, RatingDTO ratingDTO);
    void removeRating(User user, Violation violation);
}
