package com.shaoshao.dao;

import com.shaoshao.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/29 15:12
 */
public interface TypeRespository extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
