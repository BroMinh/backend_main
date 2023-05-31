package com.haui.project.controller;

import com.haui.project.entity.User;
import com.haui.project.model.dto.UserDto;
import com.haui.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        List<UserDto> users = userService.searchUser(name);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        User user = userService.createUser(newUser);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User upUser){
        User user = userService.updateUser(id, upUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path="/delete/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        boolean user = userService.deleteUser(id);
        return ResponseEntity.ok(user);
    }
}
