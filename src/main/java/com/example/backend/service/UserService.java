package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    // コンストラクタ
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ユーザー一覧取得
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // ユーザー取得
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ユーザー登録
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // ユーザー削除
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
