package com.shaoshao.dao;

import com.shaoshao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/28 18:23
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
