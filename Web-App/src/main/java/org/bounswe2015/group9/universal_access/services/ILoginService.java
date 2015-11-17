package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.entities.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ILoginService {

    User login(String userName, String password) throws UsernameNotFoundException, BadCredentialsException;
}
