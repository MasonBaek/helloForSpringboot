package hello.hellospring.service;


import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

  MemberService memberService = new MemberService();
  // 회원가입
  @Test
  void 회원가입() {
    // given
    Member member = new Member();
    member.setName("hello");
    // when
    Long saveId = memberService.join(member);
    
    //then
    Member fineMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(fineMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member1.setName("spring");
    //when
    memberService.join(member1);
    memberService.join(member2);

    //then

  }
 @Test
  void findMembers() {
  }

  @Test
  void findOne() {
  }

}
