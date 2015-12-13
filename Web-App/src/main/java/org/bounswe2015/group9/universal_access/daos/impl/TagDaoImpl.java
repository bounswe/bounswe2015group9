package org.bounswe2015.group9.universal_access.daos.impl;

import org.bounswe2015.group9.universal_access.daos.ITagDao;
import org.bounswe2015.group9.universal_access.entities.Tag;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by umut on 12.12.2015.
 */
@Repository
public class TagDaoImpl extends BaseDaoImpl<Tag,Long> implements ITagDao{
    @Override
    public List<Tag> getTagsByViolation(Long violationId){
        Criteria criteria = getCurrentSession().createCriteria(Tag.class, "tag");
        criteria.createAlias("violation", "violation");
        criteria.add(Restrictions.eq("violation.id",violationId));

        return criteria.list();
    }

}
