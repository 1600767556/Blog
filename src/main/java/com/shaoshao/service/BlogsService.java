package com.shaoshao.service;

import com.shaoshao.po.Blog;
import com.shaoshao.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 14:03
 */
public interface BlogsService {
    Blog getBlog(Long id);
    Blog getAndConvert(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(Long tagId,Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);
    List<Blog> listRecommendBlogTop(Integer size);
    Map<String, List<Blog>> archiveBlog();
    Long countBlog();
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);


}
