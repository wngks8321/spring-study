package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // memberService를 스프링이 스프링 컨테이너에 있는 memberService를 가져와서 연결해줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //new로 작성하면 매번 인스턴스가 생성되는데 스프링 컨테이너에 등록하면 한번만 생성해서 사용할 수 있다고함.
}
