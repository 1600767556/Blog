package com.shaoshao.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/29 12:38
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    @GetMapping("/blogs")
    public String blogs() {
        return "admin/blogs";

    }

}
