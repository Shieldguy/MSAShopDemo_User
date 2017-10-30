package com.msa.user.controller;

import com.msa.common.service.CrudPagingEntityService;
import com.msa.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private CrudPagingEntityService<User, Long> userService;

    @GetMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity gets(Principal principal, HttpServletRequest request) {
        return null;
    }

    @GetMapping(path = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity get(Principal principal, @PathVariable("id") Long id) {
        return null;
    }

    @PostMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add(Principal principal, HttpServletRequest request, @RequestBody User user) {
        return null;
    }

    @PutMapping(path = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity update(Principal principal, HttpServletRequest request, @RequestBody User user) {
        return null;
    }

    @DeleteMapping(path = "/api/users/{id}")
    public ResponseEntity delete(Principal principal, HttpServletRequest request, @PathVariable("id") Long id) {
        return null;
    }

    @GetMapping(path = "/api/users/count")
    public Long count(Principal principal) {
        return null;
    }
}
