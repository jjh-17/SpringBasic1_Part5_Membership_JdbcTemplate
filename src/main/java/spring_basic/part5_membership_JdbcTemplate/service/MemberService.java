package spring_basic.part5_membership_JdbcTemplate.service;

import spring_basic.part5_membership_JdbcTemplate.domain.Member;
import spring_basic.part5_membership_JdbcTemplate.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //외부에서 값을 받는다
    }

    public Long join(Member member){
        checkDuplicateName(member);     //중복 이름 확인
        memberRepository.save(member);
        return member.getId();

    }

    private void checkDuplicateName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }
}
