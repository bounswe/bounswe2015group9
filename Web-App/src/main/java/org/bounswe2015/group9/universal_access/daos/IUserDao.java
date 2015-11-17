package org.bounswe2015.group9.universal_access.daos;

import org.bounswe2015.group9.universal_access.entities.User;

public interface IUserDao extends IBaseDao<User, Long>{
    User getUserByEmail(String email);
}
