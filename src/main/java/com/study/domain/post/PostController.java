package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id,  Model model){

        if(id != null){
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }

        return "post/write";
    }

    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params){
        postService.savePost(params);
        return "redirect:/post/list.do";
    }
}
