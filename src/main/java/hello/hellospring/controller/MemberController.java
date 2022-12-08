package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // memberService를 스프링이 스프링 컨테이너에 있는 memberService를 가져와서 연결해줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //new로 작성하면 매번 인스턴스가 생성되는데 스프링 컨테이너에 등록하면 한번만 생성해서 사용할 수 있다고함.

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        // model 이라는 곳에 members 키로 members List를 add함. -> 이 값은 thymeleaf에서 가져와서 쓸 수 있음.
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
