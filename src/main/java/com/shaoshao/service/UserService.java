package com.shaoshao.service;

import com.shaoshao.po.User;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/28 18:20
 */
public interface UserService {
    User checkUser(String username,String password);
}
