package org.bounswe2015.group9.universal_access.daos.impl;

import org.bounswe2015.group9.universal_access.daos.IViolationDao;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViolationDaoImpl extends BaseDaoImpl<Violation, Long> implements IViolationDao{
    @Override
    public List<Violation> getViolationsByOwner(Long userId, Boolean closed) {
        Criteria criteria = getCurrentSession().createCriteria(Violation.class, "violation");
        criteria.createAlias("user", "user");
        criteria.add(Restrictions.eq("user.id", userId));

        if(closed != null) {
            criteria.add(Restrictions.eq("closed", closed));
        }

        return criteria.list();
    }

    @Override
    public List<Violation> getViolations(Boolean closed) {
        Criteria criteria = getCurrentSession().createCriteria(Violation.class, "violation");
        criteria.add(Restrictions.eq("closed", closed));

        return criteria.list();
    }
}
