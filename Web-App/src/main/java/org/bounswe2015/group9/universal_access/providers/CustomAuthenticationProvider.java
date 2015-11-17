package org.bounswe2015.group9.universal_access.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bounswe2015.group9.universal_access.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.bounswe2015.group9.universal_access.services.ILoginService;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    /** LoginService service bean */
    @Autowired
    ILoginService loginSvc;

    /** Logger */
    private final static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    /**
     * Override the authenticate method to implement our custom authentication logic agains LoginService api.
     */
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        logger.debug("entered CustomAuthenticationProvider.authenticate() with arguments: {}", auth.toString());
        //extract user name and password from Authentication instance
        String userName = (String) auth.getPrincipal();
        String password = (String) auth.getCredentials();
        //call LoginService login to authenticate the user name and password
        logger.debug("calling LoginService.login for user: {}", userName);
        User user = loginSvc.login(userName, password);
        //create GrantedAuthority collection from retrieved roles
        Collection<? extends GrantedAuthority> authorties = user.getAuthorities();
        //create a fully populated authentication object
        Authentication filledAuthentication = new UsernamePasswordAuthenticationToken(user, password, authorties);
        logger.info("created fully populated authentication object {}", filledAuthentication.toString());
        logger.debug("exiting authenticate()");
        return filledAuthentication;
    }

    public boolean supports(Class<?> arg0) {
        return true;
    }

}
