package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    User findUser();

    User findUser(SecurityContext securityContext);

    User createUser(User user);

}


