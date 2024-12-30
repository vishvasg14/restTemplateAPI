package com.testing.test.service;

import com.testing.test.model.User;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {


    private final Map<String, String> userList = new HashMap<>();

    public List<String> getAllUsers() {
        return new ArrayList<>(userList.keySet());
    }

    public ArrayList<String> setUsers(User user) {
        userList.put(user.getName(), user.getNumber());
        return new ArrayList<>(userList.keySet());
    }

    public String deleteUsers(String name) {
        if (userList.containsKey(name)) {
            userList.remove(name);
            return "deleted";
        } else {
            return "user not found";
        }
    }

    public User updateUsers(User user) {
        if (userList.containsKey(user.getName())) {
            userList.put(user.getName(), user.getNumber());
            return user;
        }
        return null;
    }


}
