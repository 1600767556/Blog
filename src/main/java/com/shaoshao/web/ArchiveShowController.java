package com.shaoshao.web;

import com.shaoshao.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/2 15:15
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogsService blogsService;
    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap",blogsService.archiveBlog());
        model.addAttribute("blogCount",blogsService.countBlog());
        return "archives";
    }
}
