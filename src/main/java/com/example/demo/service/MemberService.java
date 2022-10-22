package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {

        this.repository = repository;
    }

    public List<Member> findAll(){
        List<Member> result = repository.findAll();

        return result;
    }

    public void create(Member member)    {
        repository.save(member);
    }

    public Member findOne(Long memberId){
        Member result = repository.findOne(memberId);
        return result;
    }
}
