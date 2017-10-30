package com.msa.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.user.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc         mockMvc;

    private ObjectMapper    mapper = new ObjectMapper();

    @BeforeClass
    public void addingTestUser() throws Exception {

    }

    @Test
    public void getUserList() throws Exception {

    }

    @Test
    public void getSpecifiedUser() throws Exception {

    }

    @Test
    public void addUser() throws Exception {
        User user = User.builder().username("guess@whoami.com")
                .passowrd("test1122")
                .name("James")
                .enabled(true)
                .build();

        this.mockMvc.perform(post("/api/users", user))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void modifyUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }


    @Test
    public void checkUserCount() throws Exception {

    }
}
