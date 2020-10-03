package com.shaoshao.web;


import com.shaoshao.po.Blog;
import com.shaoshao.po.Tag;
import com.shaoshao.service.BlogsService;
import com.shaoshao.service.TagService;
import com.shaoshao.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/26 16:34
 */
@Controller
public class IndexController {
    @Autowired
    private BlogsService blogsService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String Index(@PageableDefault(size = 6,
            sort = {"updateTime"},
            direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        model.addAttribute("page", blogsService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(5));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogsService.listRecommendBlogTop(5));
        return "index";
    }


    @PostMapping("/search")
    public String search(@PageableDefault(size = 5,
            sort = {"updateTime"},
            direction = Sort.Direction.DESC)
                                 Pageable pageable, @RequestParam String query, Model model) {
        model.addAttribute("page",blogsService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";

    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog",blogsService.getAndConvert(id));
        return "blog";
    }
    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs",blogsService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}
