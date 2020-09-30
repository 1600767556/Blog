package com.shaoshao.service;


import com.shaoshao.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/29 13:13
 */
public interface TypeService {

    Type saveType(Type type);
    Type getType(Long id);
    Type getTypeByName(String name);
    Page<Type> listType(Pageable pageable);
    Type updateType(Long id,Type type);
    void deleteType(Long id);
}