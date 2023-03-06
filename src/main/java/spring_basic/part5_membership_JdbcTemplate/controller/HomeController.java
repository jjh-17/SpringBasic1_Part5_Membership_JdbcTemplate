package spring_basic.part5_membership_JdbcTemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /*
    같은 링크에서 열리는 경우, Controller는 정적 html 파일애 우선한다.
     */

    @GetMapping("/") //처음 localhost로 이동 하면 아래 페이지가 열린다
    public String home() {
        return "home";
    }
}
