package hello.advanced.trace;

import lombok.Data;

import java.util.UUID;

@Data
public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public String createId() {

        // 앞 8자리만 사용
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 아이디는 동일, 레벨 1씩 증가
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    // 아이디는 동일, 레벨 1씩 감소
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
