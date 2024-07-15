package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;

/*
* 필드의 전략을 보관하는 방식
* */
@Slf4j
public class StrategyContextV1 {

    private Strategy strategy;

    public StrategyContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {

        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        strategy.call();
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);

    }

}
