package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//나는 컨트롤러야
@Controller//고객이 요청하고 응답을 줄 수 있는 클래스(통신), 서블릿을 써서 request, response처리를 했었음(옛날에) 스프링에서는 컨트롤러
public class HelloController {

//    @GetMapping("hello")
//    // 스프링이 지원하는 UI 라이브러리인 Model이 필요하다.
//    public String hello(Model model){
//        model.addAttribute("name", "minyoung");
//        return "hello";
//    } //전체 주석 단축 키 : Ctrl+/(슬래쉬)

    //DB connection이 굉장히 중요=>회사마다 다름 요즘에는 jpa로 통일이 되어가고 있는 상황, 다른 방식도 얘기해주심.

    //화면 요청,SSR
    @GetMapping("hello") // 화면으로 던져줌
    // 스프링이 지원하는 UI 라이브러리인 Model이 필요하다.
    public String hello(@RequestParam (value="name")String name, Model model){ //model은 parameter,매개변수.
        model.addAttribute("name", name);
        return "hello";
    }//22~28줄 복습하기.

    //데이터 요청,CSR,지금은 문자형, 다음시간부터는 어떤 식으로 객체 형태로 받게 되는지. json에서 객체라고 부르는 것->java와는 다름
    /*데이터만 던져줌*/@GetMapping("hello-string")// 고객이 요청하면 응답을 줄게 //chrome 브라우저에 localhost:9098/hello-api를 입력하면 hello-string을 출력. 순수 api, 화면X
    @ResponseBody //ResponseBody가 있어야 데이터를 리턴한다.
    public String helloString(){ //helloString 메소드 생성, return 값은 "hello-string"
        return "hello-string"; //사용자가 들어왔을 때, hello-string이라는 메시지가 찍히도록 해야 함.
    }



    @GetMapping("hello-api") //get요청으로 name_input으로 입력을 받고 , 그 값을 43번째 줄에 저장
    @ResponseBody
    public Hello helloApi(@RequestParam (value="name")String name_input){ //Hello라는 클래스를 만듦(set 객체 리턴, get String(String을 하기 위해서는 Hello를 String으로 바꿔줘야 함)은 리턴이 안 됨)
        Hello hello = new Hello();
        String name="name_input";
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
