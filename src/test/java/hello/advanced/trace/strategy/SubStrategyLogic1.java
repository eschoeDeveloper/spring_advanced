package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubStrategyLogic1 implements Strategy{

    @Override
    public void call() {
        log.info("비즈니스 로직 1");
    }
}
