package com.shaoshao.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/26 16:34
 */
@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String Index() {
        //System.out.println(10/0);
      /*  String blog = null;
        if (blog == null){
            throw new NotFoundException("博客不存在");
        }*/
        System.out.println("----------index------------");
        return "index";
    }
    @GetMapping(value = "/blog")
    public String Blog() {
        System.out.println("----------index------------");
        return "blog";
    }
    @GetMapping(value = "/blog404")
    public String Blog404() {
        System.out.println("----------index------------");
        return "about";
    }
}
