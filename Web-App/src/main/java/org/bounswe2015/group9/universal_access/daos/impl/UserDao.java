package org.bounswe2015.group9.universal_access.daos.impl;

import org.bounswe2015.group9.universal_access.daos.IUserDao;
import org.bounswe2015.group9.universal_access.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User, Long> implements IUserDao{
    @Override
    public User getUserByEmail(String email) {
        return super.readByProperty("email", email);
    }
}
