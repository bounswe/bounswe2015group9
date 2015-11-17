package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/rest/protectedSvc")
public class ProtectedSvc {

    @RequestMapping("/hello")
    @ResponseBody
    public String ping(OAuth2Authentication auth) {
        User user = (User) auth.getUserAuthentication().getPrincipal();

        return user.getEmail();
    }
}