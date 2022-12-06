package com.nnk.springboot.service.impl;

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(BidListController.class);
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;



    @Override
    public User findUser() {
        return findUser(SecurityContextHolder.getContext());
    }

    @Override
    public User findUser(SecurityContext securityContext) {
        String username = securityContext.getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        logger.info("enregistrement de l'objet user{}", user);

        User user1 = userRepository.findByUsername(user.getUsername());
        if (user1 == null) {
            logger.info("utilisateur enregistrer avec succès");
            return userRepository.save(user);
        } else {
            logger.warn("l'utilisateur existe deja");

            return user1;

        }

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(email);
        if (user == null) {
            logger.error("utilisateur introuvable");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}