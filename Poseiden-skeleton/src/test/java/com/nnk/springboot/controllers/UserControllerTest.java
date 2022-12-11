package com.nnk.springboot.controllers;


import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.UserService;
import junit.framework.TestCase;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class UserControllerTest extends TestCase {
    @InjectMocks
    private UserController userController;

    @Mock
    public UserRepository userRepository;

    @Mock
    public Model model;

    @Mock
    public BindingResult bindingResult;
    @Mock
    public BCryptPasswordEncoder encoder;



    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userController.setEncoder(encoder);
    }

    @Test
    public void testHome() throws Exception {
        //given

        when(userRepository.findAll()).thenReturn(Lists.newArrayList(new User()));

        //when
        userController.home(model);
        //then
        verify(userRepository, times(1)).findAll();

    }

    @Test
    public void testAddUser(){

        String reponse = userController.addUser(new User());
        assertEquals("user/add", reponse);
    }

    @Test
    public void testValidate(){
        when(bindingResult.hasErrors()).thenReturn(false);
        String retour = userController.validate(new User(), bindingResult, model);
        assertEquals("redirect:/user/list", retour);

    }
    @Test
    public void testValidateError(){
        when(bindingResult.hasErrors()).thenReturn(true);
        String retour = userController.validate(new User(), bindingResult, model);
        assertEquals("user/add", retour);
    }
    @Test
    public void testShowUpdateForm(){
        when(userRepository.findById(1)).thenReturn(Optional.of(new User()));
        String retour = userController.showUpdateForm(1,model);
        assertEquals("user/update", retour);
    }

    @Test
    public void testUpdateUsererror(){
        when(bindingResult.hasErrors()).thenReturn(true);
        String retour = userController.updateUser(null, null, bindingResult, model);
        assertEquals("user/update", retour);
    }

    @Test
    public void testUpdateUser(){
        when(bindingResult.hasErrors()).thenReturn(false);
        String retour = userController.updateUser(null, new User(), bindingResult, model);
        assertEquals("redirect:/user/list", retour);
    }

    @Test
    public void testDeleteUser(){
        when(userRepository.findById(1)).thenReturn(Optional.of(new User()));
        String retour = userController.deleteUser(1,model);
        assertEquals("redirect:/user/list", retour);
    }



}
