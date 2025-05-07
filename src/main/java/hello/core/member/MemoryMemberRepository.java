package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{
    private final static Map<Long, Member> store =new HashMap<>();
    @Override
    public void save(Member member) {
        Member member1=store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
}
