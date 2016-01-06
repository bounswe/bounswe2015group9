package org.bounswe2015.group9.universal_access.services.impl;

import org.bounswe2015.group9.universal_access.daos.IRatingDao;
import org.bounswe2015.group9.universal_access.dtos.RatingDTO;
import org.bounswe2015.group9.universal_access.entities.Rating;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.bounswe2015.group9.universal_access.services.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by umut on 07.12.2015.
 */
@Service("ratingService")
public class RatingService implements IRatingService{
    @Autowired
    IRatingDao ratingDao;

    @Override
    public RatingDTO getRating(User user, Violation violation) {
        Rating rating = ratingDao.getRating(user.getId(),violation.getId());
        return new RatingDTO(rating);
    }

    @Override
    public RatingDTO setRating(User user, Violation violation,RatingDTO ratingDTO) {
        Rating rating = new Rating(ratingDTO,user,violation);
        ratingDao.create(rating);
        return new RatingDTO(rating);
    }

    @Override
    public RatingDTO updateRating(Rating rating, RatingDTO ratingDTO) {
        rating.setScore(ratingDTO.getScore());
        ratingDao.update(rating);
        return null;
    }

    @Override
    public void removeRating(User user, Violation violation) {
        Rating rating = ratingDao.getRating(user.getId(),violation.getId());
        ratingDao.delete(rating);
    }
}
