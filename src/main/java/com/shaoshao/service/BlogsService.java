package com.shaoshao.service;

import com.shaoshao.po.Blog;
import com.shaoshao.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 14:03
 */
public interface BlogsService {
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);

}
