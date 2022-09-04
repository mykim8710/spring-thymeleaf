package com.example.thymeleaf.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/template")
public class TemplateController {

    /**
     * 템플릿 조각 사용
     */
    @GetMapping("/fragment")
    public String template() {
        log.info("[GET]  /template/fragment");
        return "template/fragment/fragmentMain";
    }

    /**
     * 템플릿 레이아웃1 : <head>적용
     */
    @GetMapping("/layout")
    public String layout() {
        log.info("[GET]  /template/layout");
        return "template/layout/layoutMain";
    }

    /**
     * 템플릿 레이아웃2 : <html> 전체에 적용
     */
    @GetMapping("/layoutExtend")
    public String layoutExtends() {
        log.info("[GET]  /template/layoutExtend");
        return "template/layoutExtend/layoutExtendMain";
    }
}
