package org.bounswe2015.group9.universal_access.daos.impl;

import org.bounswe2015.group9.universal_access.daos.IUserDao;
import org.bounswe2015.group9.universal_access.entities.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao{
    @Override
    public User getUserByEmail(String email) {
        return super.readByProperty("email", email);
    }

    @Override
    public User getUserWithViolations(Long id, Boolean active) {
        Criteria criteria = getCurrentSession().createCriteria(User.class, "user");
        criteria.add(Restrictions.eq("id", id));
        criteria.setFetchMode("user.violations", FetchMode.JOIN);

        Object result = criteria.uniqueResult();
        return result == null ? null : (User) result;
    }

    @Override
    public User getUserById(String id) {
        return super.readByProperty("id", id);
    }
//    @Override
//    public List<User> getAllUsers(){return super.getAll();}
}
