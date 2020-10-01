package com.shaoshao.dao;

import com.shaoshao.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 13:49
 */
public interface BlogRespository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

}
