package com.msa.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.user.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc         mockMvc;

    private ObjectMapper    mapper = new ObjectMapper();

    @Test
    public void getUserListWithManagerRole() throws Exception {
        this.mockMvc.perform(get("/api/users?page=0&count=10")
                            .with(user("test@where.com").password("test1234").roles("MANAGER")))
                //.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUserInfoByOwner() throws Exception {
        User user = User.builder()
                .username("test@where.com")
                .password("test1234")
                .name("James")
                .enabled(true)
                .build();
        user.setId(1L);
        String jsonData = mapper.writeValueAsString(user);

        this.mockMvc.perform(get("/api/users/1")
                            .with(user("test@where.com").password("test1234").roles("USER")))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(jsonData));
    }

    @Test
    public void addUser() throws Exception {
        User user = User.builder()
                .username("guess@whoami.com")
                .password("test1122")
                .name("James")
                .enabled(true)
                .build();

        String json = mapper.writeValueAsString(user);
        MvcResult result = this.mockMvc.perform(post("/api/users")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .with(csrf().asHeader()))
                //.andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        User addedUser = mapper.readValue(result.getResponse().getContentAsString(), User.class);
        assertTrue(user.getUsername().compareTo(addedUser.getUsername()) == 0);
        assertTrue(user.getPassword().compareTo(addedUser.getPassword()) == 0);
        assertTrue(user.getName().compareTo(addedUser.getName()) == 0);
        assertTrue(user.isEnabled() == addedUser.isEnabled());
        assertTrue(addedUser.getId() > 0);
        assertNotNull(addedUser.getRegDate());
        assertNotNull(addedUser.getModDate());
    }

    @Test
    public void modifyUser() throws Exception {
        User user = User.builder()
                .username("guess@whoami.com")
                .password("test1122")
                .name("James Cross")
                .enabled(false)
                .build();
        user.setId(2L);

        String json = mapper.writeValueAsString(user);
        MvcResult result = this.mockMvc.perform(put("/api/users/2")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .with(user("guest@whoami.com").password("test1122").roles("USER"))
                        .with(csrf().asHeader()))
                //.andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        User modUser = mapper.readValue(result.getResponse().getContentAsString(), User.class);
        assertTrue(user.getUsername().compareTo(modUser.getUsername()) == 0);
        assertTrue(user.getPassword().compareTo(modUser.getPassword()) == 0);
        assertTrue(user.getName().compareTo(modUser.getName()) == 0);
        assertTrue(user.isEnabled() == modUser.isEnabled());
        assertTrue(user.getId() == modUser.getId());
        assertNotNull(modUser.getModDate());
    }

    @Test
    public void deleteUser() throws Exception {
        this.mockMvc.perform(delete("/api/users/2")
                        .with(user("guest@whoami.com").password("test1122").roles("USER"))
                        .with(csrf().asHeader()))
                //.andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/users/2")
                        .with(user("guest@whoami.com").password("test1122").roles("USER")))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void checkUserCountWithManagerRole() throws Exception {
        this.mockMvc.perform(get("/api/users/count")
                            .with(user("test@where.com").password("test1234").roles("MANAGER")))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }
}
