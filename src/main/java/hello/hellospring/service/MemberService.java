package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

  private final MemberRepository memberRepository;

  // DI - dependency injection
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /*
  * 회원 가입
  * */
  public Long join(Member member) {
    // 같은 이름이 있는 중복 회원 X
    //Optional<Member> result = memberRepository.findByName(member.getName());
    // Optinal 로 바로 반환하는 것을 권장하지않음 아래코드로 반환이 바람직함
    // ctrl + alt + M -> abstract method

    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  // 존재 하는 회원체크
  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
      .ifPresent(m -> {
        throw  new IllegalStateException("이미 존재 하는 회원입니다");
      });
  }

  /*
  * 전체 회원 조회
  * */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  /*
  *회원 한명 조회회
 * */
  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }

}
