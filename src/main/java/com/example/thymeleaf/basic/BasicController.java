package com.example.thymeleaf.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        log.info("[GET] /basic/text-basic");
        model.addAttribute("data", "hello Spring~!!");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        log.info("[GET] /basic/text-unescaped");
        model.addAttribute("data", "<b>hello Spring</b>~!!");
        return "basic/text-unescaped";
    }
}
