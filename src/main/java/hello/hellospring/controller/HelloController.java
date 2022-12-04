package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        /*
        * controller에서 return 값으로 문자열을 반환하면 viewResolver가 화면을 찾아서 처리함.
        * return "hello"; 는 resources/templates 아래의 hello를 찾음.
        * 즉, 여기서 return "hello";는 resources/templates/hello.html 을 선택.
        * */
        return "hello";
    }
}
