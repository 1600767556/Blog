package com.shaoshao.service;

import com.shaoshao.dao.UserRepository;
import com.shaoshao.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/28 18:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
       User user =  userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
}
