package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {


    User findUser();

    User findUser(SecurityContext securityContext);

    /*User createUser(User user);*/

    User findById(Integer id);

    void save(User user);

    void deleteById(Integer id);

    List<User> findUserList ();
}


