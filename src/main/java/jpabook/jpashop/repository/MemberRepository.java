package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){ //단건조회
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); //jpql 문법, sql과 거의 비슷 but 대상이 테이블이 아니라 엔티티!
    }

    public List<Member> findbyName(String name){ //name으로 회원찾기
        return em.createQuery("select m from Member m where m.name = :name",
                Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}
