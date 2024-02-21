package com.mjv.school.controller;

import com.mjv.school.dto.UserDTO;
import com.mjv.school.model.User;
import com.mjv.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id).get();
    }

    @PostMapping("save")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}