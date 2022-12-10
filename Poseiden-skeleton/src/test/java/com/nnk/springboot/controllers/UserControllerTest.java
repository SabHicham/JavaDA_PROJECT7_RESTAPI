package com.nnk.springboot.controllers;

import com.google.inject.internal.util.Lists;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {


    @MockBean
    private UserService userservice;

    @Mock
    private User user;




    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getUserTest() throws Exception {
        User user1 = new User();
        User user2 = new User();


        doReturn(Lists.newArrayList(user1, user2)).when(userservice).findUser();

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk());

        verify(userservice, times(1)).findUser();

    }

        /*@Test
        @DisplayName("POST /person")
        public void postPersonTest() throws Exception {
            mockMvc.perform(post("/person").content(asJsonString(new PersonDto("","",
                            ", ", "", "", "", "")))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));

            verify(service, times(1)).addPerson(any());
        }
        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        @DisplayName("PUT /person")
        public void putFireStationTest() throws Exception {
            mockMvc.perform(put("/person")
                    .content(asJsonString(new PersonDto("", "", "",
                            "", "", "", "")))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));

            verify(service, times(1)).updatePerson(any());
        }*/

    /*@Test
    @DisplayName("DELETE /person")
    public void deletePersonTest() throws Exception {
        mockMvc.perform(delete("/person")
                        .content(asJsonString(new PersonDto("", "", "", "", "", "", "")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service, times(1)).deletePerson("A", "B");
    }*/


    public void testHome() {
    }

    public void testAddUser() {
    }

    public void testValidate() {
    }

    public void testShowUpdateForm() {
    }

    public void testUpdateUser() {
    }

    public void testDeleteUser() {
    }
}