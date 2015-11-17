package org.bounswe2015.group9.universal_access.services.impl;


import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.bounswe2015.group9.universal_access.services.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    IUserService userService;

    public User login(String userName, String password) throws UsernameNotFoundException, BadCredentialsException {
        User user = userService.loadUserByUsername(userName);

        if (!user.getPassword().equals(password))
        {
            throw new BadCredentialsException("email or password not valid.");
        }
        return user;
    }
}
