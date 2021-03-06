package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService {
    User getUser(Long id);

    List<User> getAllUsers();

    List<UserDTO> getAllUserDTOs();

    User createUser(User user);

    User createUser(UserDTO user);

    void updateUser(User user);

    void updateUser(UserDTO user);

    void deleteUser(Long id);

    public User loadUserByUsername(String s) throws UsernameNotFoundException;
}
