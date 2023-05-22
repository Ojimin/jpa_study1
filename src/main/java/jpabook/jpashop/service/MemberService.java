package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //트랜잭션 안에서 변경이 이뤄야져야 하므로
@RequiredArgsConstructor //final 키워드로 생성자를 주입하는 것
public class MemberService {
    private final MemberRepository memberRepository;

    //회원가입
    @Transactional //변경이 이뤄야져야 하므로
    public Long join(Member member){
        validateDuplicateMember(member);//중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    //EXCEPTION
    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findbyName((member.getName()));
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
    //회원전체조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
