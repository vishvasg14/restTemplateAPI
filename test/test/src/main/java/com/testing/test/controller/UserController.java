package com.testing.test.controller;

import com.testing.test.model.User;
import com.testing.test.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/getUser")
//    public List<String> getUser() {
//        return userService.getAllUsers();
//    }
//
//    @PostMapping("/setUser")
//    public List<String> setUser(@RequestBody User user) {
//        return userService.setUsers(user);
//    }
//
//    @DeleteMapping("/deleteUser")
//    public String deleteUser(@PathParam("name") String name) {
//        return userService.deleteUsers(name);
//    }
//
//    @PostMapping("/updateUser")
//    public User updateUser(@RequestBody User user) {
//        return userService.updateUsers(user);
//    }

}
