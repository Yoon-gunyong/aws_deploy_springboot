package com.example.demo.controller;

import com.example.demo.domain.Member; //domain에는 필요한 객체를 담아둠
import com.example.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
    this.memberService = memberService;
    }

    @GetMapping("/members/new") // /members/new 검색
    public String createForm(){

        return "members/createMemberForm"; //controller부터 찾고 없으면 templates로 감
    }


//  회원가입 많은 데이터들이 넘어올 거 아니에요? post방식을
    @PostMapping("/members/new")
    public String create(MemberPostForm memberPostForm){
        Member member = new Member();
        member.setName(memberPostForm.getName());
        member.setContent(memberPostForm.getContent());
  //회원가입로직
       memberService.create(member);
       return "redirect:/";
    }
    //화면에다가 db에서 조회한 값을 넘겨받으려면 어떻게해야하나?


    // 회원목록 데이터를 넘겨받을 이유가 없다.
    @GetMapping("/members")
    public String memberList(Model model){
        model.addAttribute("members", memberService.findAll());

        return "members/memberList";
    }
    @GetMapping("memberfindId")
    public String findcontent(Model model, @RequestParam(value="id") int id, @RequestParam(value="name") String name){
        model.addAttribute("id", id);
        model.addAttribute("name",name);


        return "/memberdetail";
    }
    @GetMapping("/findOne")
    public String findOne(@RequestParam(value="id") Long id, Model model){
        model.addAttribute("member", memberService.findOne(id));
        return "members/memberdetail";
    }
}

