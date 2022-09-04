package com.example.thymeleaf.basic;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/basic")
public class BasicController {

    /**
     * 기본 기능 - 텍스트 - text, utext
     */

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

    /**
     * 기본 기능 - 변수 - SpringEL
     */
    @GetMapping("/variable")
    public String variable(Model model) {
        log.info("[GET] /basic/variable");

        User userA = new User("userA", 10);
        User userB = new User("userB", 10);

        List<User> users = new ArrayList<>();
        users.add(userA);
        users.add(userB);

        Map<String, User> userMap = new HashMap<>();
        userMap.put("userA", userA);
        userMap.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", users);
        model.addAttribute("userMap", userMap);

        return "basic/variable";
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    /**
     * 기본 기능 - 기본 객체들
     */
    @GetMapping("/basic-objects")
    public String basicObjects(HttpSession session) {
        log.info("[GET] /basic/basic-objects");
        session.setAttribute("sessionData", "Hello Session");
        return "basic/basic-objects";
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }

    /**
     * 기본 기능 - 유틸리티 객체와 날짜
     */
    @GetMapping("/date")
    public String date(Model model) {
        log.info("[GET] /basic/date");
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    /**
     * 기본 기능 - URL 링크
     */
    @GetMapping("/link")
    public String link(Model model) {
        log.info("[GET] /basic/link");
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    /**
     * 기본 기능 - 리터럴
     */
    @GetMapping("/literal")
    public String literal(Model model) {
        log.info("[GET] /basic/literal");
        model.addAttribute("data", "Spring!");
        return "basic/literal";
    }


}
