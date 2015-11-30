package org.bounswe2015.group9.universal_access.daos;

import org.bounswe2015.group9.universal_access.entities.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User, Long>{
    User getUserByEmail(String email);
    User getUserById(String id);
//    List<User> getAllUsers();

}
