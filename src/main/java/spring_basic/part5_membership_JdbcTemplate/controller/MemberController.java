package spring_basic.part5_membership_JdbcTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring_basic.part5_membership_JdbcTemplate.domain.Member;
import spring_basic.part5_membership_JdbcTemplate.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌 ==> 의존성 주입(D.I)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    //GetMapping과 같은 url 이더라도 post 이후나, 단순 방문이냐에 따라 호출되는 함수가 달라짐
    @PostMapping("/members/new")
    public String create(MemberForm form) { //form이
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //redirect: 우측 url로 이동한다.
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); //MemberList.html의 members에 인자로 받은 members 대입

        return "members/memberList";
    }

}