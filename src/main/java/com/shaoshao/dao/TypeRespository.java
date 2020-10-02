package com.shaoshao.dao;

import com.shaoshao.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/29 15:12
 */
public interface TypeRespository extends JpaRepository<Type,Long> {

    Type findByName(String name);
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
