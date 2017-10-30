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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public static void addingTestUser() throws Exception {

    }

    @Test
    public void getUserList() throws Exception {
        this.mockMvc.perform(get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getSpecifiedUser() throws Exception {
        this.mockMvc.perform(get("/api/users/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addUser() throws Exception {
        User user = User.builder()
                .username("guess@whoami.com")
                .password("test1122")
                .name("James")
                .enabled(true)
                .build();

        this.mockMvc.perform(post("/api/users", user))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void modifyUser() throws Exception {
        User user = User.builder()
                .username("guess@whoami.com")
                .password("test1122")
                .name("James")
                .enabled(true)
                .build();
        user.setId(1L);

        this.mockMvc.perform(put("/api/users/1", user))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception {
        this.mockMvc.perform(delete("/api/users/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void checkUserCount() throws Exception {
        this.mockMvc.perform(get("/api/users/count"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
