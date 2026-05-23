package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.User;
import com.example.backend.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ユーザー一覧
    @GetMapping("api/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // ユーザー取得
    @GetMapping("api/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // ユーザー登録
    @PostMapping("api/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // ユーザー削除
    @DeleteMapping("api/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // ユーザー更新
    @PutMapping("api/users/{id}")
    public User updataUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
