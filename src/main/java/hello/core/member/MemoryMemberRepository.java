package hello.core.member;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    // 동시성 이슈로 인해 ConcurrentHashMap 사용
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    /**
     * 멤버 저장 로직
     * member 가 null 일 경우 return
     * @param member 저장 하고자 하는 멤버 객체
     */
    @Override
    public void save(Member member) {
        if(member == null) return;
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
