package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public void save(Member member){

        ++sequence;
        member.setId(sequence);
        store.put(sequence, member);
        System.out.println(store);
    }

    public List<Member> findAll(){

        return new ArrayList<>(store.values());
    }

    public Member findOne(Long memberId){
        Member result = store.get(memberId);
        return result;

    }
}
