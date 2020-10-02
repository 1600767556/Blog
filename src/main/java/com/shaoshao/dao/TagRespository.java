package com.shaoshao.dao;

import com.shaoshao.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 9:40
 */
public interface TagRespository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
