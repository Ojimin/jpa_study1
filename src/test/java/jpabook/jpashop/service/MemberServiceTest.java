package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import javax.transaction.Transactional;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //스프링 부트랑 연계해서
@SpringBootTest
@Transactional //이게 있어야 롤백이 됨
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId)); //저장한 멤버랑 멤버리포지토리에 저장된 거랑 비교

    }
    @Test(expected = IllegalStateException.class) //예외가 illegalexception이면 에러가 잡힘
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1=new Member();
        member1.setName("kim");

        Member member2=new Member();
        member2.setName("kim");
        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야한다

        //then
        fail("예외가 발생해야 한다.");
    }
}