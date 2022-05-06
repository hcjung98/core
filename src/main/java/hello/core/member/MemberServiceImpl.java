package hello.core.member;

public class MemberServiceImpl implements MemberService{
    
    /*추상화에민 의존, DIP (SOLID), 구체적인 구현제는 없음*/
    private final MemberRepository memberRepository;

    /*클라이언트인 memberServiceImpl입장에서 보면 의존관계를 마치 외부에서 주입하는 것과 같은
    Dependency Injection (DI)*/
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*MemberServiceImpl은 의존관계에 대한 고민은 외부에 맡기도 실행에만 집중*/

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}



