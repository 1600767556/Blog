package com.shaoshao.web;

import com.shaoshao.po.Tag;

import com.shaoshao.service.BlogsService;
import com.shaoshao.service.TagService;

import com.shaoshao.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/2 10:28
 */
@Controller
public class TagShowController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 5,
            sort = {"updateTime"},
            direction = Sort.Direction.DESC)
                        Pageable pageable,
                        @PathVariable Long id,
                        Model model) {
        List<Tag> tags = tagService.listTagTop(1000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogsService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
