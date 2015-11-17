package org.bounswe2015.group9.universal_access.services.impl;

import org.bounswe2015.group9.universal_access.daos.IUserDao;
import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    IUserDao udao;

    @Override
    public User getUser(Long id) {
        return udao.read(id);
    }

    @Override
    public User createUser(User user) {
        if(user.getId() != null) {
            throw new IllegalArgumentException("Id field should be null");
        }

        Long userId = udao.create(user);

        return udao.read(userId);
    }

    @Override
    public User createUser(UserDTO user) {
        return createUser(new User(user));
    }

    @Override
    public void updateUser(User user) {
        if(user.getId() == null) {
            throw new IllegalArgumentException("id field not exists");
        }

        User existingUser = udao.read(user.getId());

        if (existingUser == null) {
            throw new RecordNotFoundException("user not found");
        }

        if(!user.getEmail().equals(existingUser.getEmail())) {
            throw new IllegalArgumentException("email field can't be changed");
        }

        udao.update(user);
    }

    @Override
    public void updateUser(UserDTO user) {
        updateUser(new User(user));
    }

    @Override
    public void deleteUser(Long id) {
        User user = udao.read(id);

        if(user == null) {
            throw new RecordNotFoundException("user not found");
        }

        udao.delete(user);
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = udao.getUserByEmail(s);

        if(user == null) {
            throw new UsernameNotFoundException("User not exists.");
        }

        return user;
    }
}
