package com.shaoshao.dao;

import com.shaoshao.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 9:40
 */
public interface TagRespository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
