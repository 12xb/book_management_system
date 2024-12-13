package com.system.service;

import com.system.entity.User;
import com.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 注册用户，直接存储用户输入的密码（未加密）。
     *
     * @param user 要注册的用户对象
     * @return 注册后的用户对象
     */
    public User registerUser(User user) {
        // 保存用户信息
        return userRepository.save(user);
    }

    /**
     * 用户登录，通过手机号和密码验证。
     *
     * @param phone 用户的手机号
     * @param password 用户的密码
     * @return 登录成功的用户对象，如果手机号或密码不正确则返回 empty
     */
    public Optional<User> loginUser(String phone, String password) {
        Optional<User> user = userRepository.findByPhone(phone);
        // 比较密码
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
