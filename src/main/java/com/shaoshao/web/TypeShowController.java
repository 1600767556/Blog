package com.shaoshao.web;

import com.shaoshao.po.Blog;
import com.shaoshao.po.Type;
import com.shaoshao.service.BlogsService;
import com.shaoshao.service.TypeService;
import com.shaoshao.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/2 10:28
 */
@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 5,
            sort = {"updateTime"},
            direction = Sort.Direction.DESC)
                        Pageable pageable,
                        @PathVariable Long id,
                        Model model) {
        List<Type> types = typeService.listTypeTop(1000);
        if (id == -1) {
            id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types",types);
        model.addAttribute("page",blogsService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
