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
    member2.setName("spring");
    //when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    assertThat(e.getMessage()).isEqualTo("이미 존재 하는 회원입니다");
/*
    try {
      memberService.join(member2);
      fail();
    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).isEqualTo("이미 존재 하는 회원입니다.12");
    }
*/
    
 @Test
  void findMembers() {
    // given 
    
    // when
    
    // then
    
  }

  @Test
  void findOne() {
    // given
    
    // when
    
    // then
    
  }

}
