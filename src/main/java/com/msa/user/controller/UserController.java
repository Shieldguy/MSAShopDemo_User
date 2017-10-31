package com.msa.user.controller;

import com.msa.common.service.CrudPagingEntityService;
import com.msa.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity gets(Principal principal, HttpServletRequest request,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "count", defaultValue = "10") Integer count) {
        return new ResponseEntity(userService.gets(new PageRequest(page, count)), HttpStatus.OK);
    }

    @GetMapping(path = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity get(Principal principal, HttpServletRequest request, @PathVariable("id") Long id) {
        return new ResponseEntity(userService.get(id), HttpStatus.OK);
    }

    @PostMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add(HttpServletRequest request, @RequestBody User user) {
        return new ResponseEntity(userService.add(user), HttpStatus.OK);
    }

    @PutMapping(path = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity update(Principal principal, HttpServletRequest request, @PathVariable("id") Long id,
                                 @RequestBody User user) {
        return new ResponseEntity(userService.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping(path = "/api/users/{id}")
    public ResponseEntity delete(Principal principal, HttpServletRequest request, @PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity("", HttpStatus.OK);
    }

    @GetMapping(path = "/api/users/count")
    public Long count(Principal principal, HttpServletRequest request) {
        return userService.count();
    }
}
