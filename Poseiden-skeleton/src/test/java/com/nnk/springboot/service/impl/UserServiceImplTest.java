package com.nnk.springboot.service.impl;


import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest extends TestCase {
    @Mock
    private SecurityContext context;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    public UserRepository userRepository;
    @Mock
    public BCryptPasswordEncoder passwordEncoder;

    @Mock
    private Authentication authentication;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindUser() {
        //given

        when(context.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("");
        when(userRepository.findByUsername(any())).thenReturn(new User());
        //when
        User user = userService.findUser(context);
        //then
        assertNotNull(user);
    }

    @Test
    public void testCreateUser() {
        //given
        when(userRepository.findByUsername(any())).thenReturn(null);
        when(userRepository.save(any())).thenReturn(new User());
        //when
        User user = userService.createUser(new User());
        //then
        assertNotNull(user);

    }
    @Test
    public void testCreateUserNotNull() {
        //given
        when(userRepository.findByUsername(any())).thenReturn(new User());
        when(userRepository.save(any())).thenReturn(new User());
        //when
        User user = userService.createUser(new User());
        //then
        assertNotNull(user);

    }

    @Test
    public void testLoadUserByUsername() {

        //given

        when(userRepository.findByUsername(any())).thenReturn(new User(1,"a","ab","abbc","Admin"));

        //when
        UserDetails user = userService.loadUserByUsername("");
        //then
        assertNotNull(user);
    }

    @Test
    public void testLoadUserByUsernameNotNull() throws Exception {
        //given
        when(userRepository.findByUsername(any())).thenReturn(null);
        //when
        //then
        assertThatThrownBy(() ->userService.loadUserByUsername("") ).isInstanceOf(UsernameNotFoundException.class);
    }
}