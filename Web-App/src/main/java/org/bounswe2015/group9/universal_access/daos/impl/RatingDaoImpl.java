package org.bounswe2015.group9.universal_access.daos.impl;

import org.bounswe2015.group9.universal_access.daos.IRatingDao;
import org.bounswe2015.group9.universal_access.entities.Rating;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by umut on 07.12.2015.
 */
@Repository
public class RatingDaoImpl extends BaseDaoImpl<Rating,Long> implements IRatingDao{
    @Override
    public Rating getRating(Long userId, Long violationId) {
        Criteria criteria = getCurrentSession().createCriteria(Rating.class, "rating");
        criteria.createAlias("violation", "violation");
        criteria.add(Restrictions.eq("violation.id", violationId));
        criteria.add(Restrictions.eq("user.id", userId));

        return (Rating)criteria.uniqueResult();
    }

    @Override
    public List<Rating> getRatingsByViolation(Long violationId,Boolean score) {
        Criteria criteria = getCurrentSession().createCriteria(Rating.class, "rating");
        criteria.createAlias("violation", "violation");
        criteria.add(Restrictions.eq("violation.id", violationId));

        if(score != null){
            criteria.add(Restrictions.eq("score",score));
        }

        return criteria.list();
    }
}
