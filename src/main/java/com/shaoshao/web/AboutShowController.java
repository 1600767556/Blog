package com.shaoshao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/2 15:59
 */
@Controller
public class AboutShowController {
@GetMapping("/about")
    public String about() {
        return "about";
    }
}
