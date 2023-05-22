package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") ///hello로 들어갔을 때 아래와 같이 연결된다
    public String hello(Model model){ //model에 다가 내용을 담아 뷰에게 넘길수있음
        model.addAttribute("data","hello!!!");
        return "hello"; //반환하는 파일명?=>.html이 자동으로 붙여짐
    }

}
