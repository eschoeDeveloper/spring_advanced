package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV1() {

        SubStrategyLogic1 logic1 = new SubStrategyLogic1();
        SubStrategyLogic2 logic2 = new SubStrategyLogic2();

        StrategyContextV1 context1 = new StrategyContextV1(logic1);
        StrategyContextV1 context2 = new StrategyContextV1(logic2);

        context1.execute();
        context2.execute();

    }

    @Test
    void strategyV2() {

        Strategy subStrategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1");
            }
        };

        Strategy subStrategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2");
            }
        };

        StrategyContextV1 context1 = new StrategyContextV1(subStrategyLogic1);
        StrategyContextV1 context2 = new StrategyContextV1(subStrategyLogic2);

        log.info("subStrategyLogic1={}", subStrategyLogic1.getClass());
        context1.execute();
        log.info("subStrategyLogic2={}", subStrategyLogic2.getClass());
        context2.execute();

    }

    @Test
    void strategyV3() {

        StrategyContextV1 context1 = new StrategyContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1");
            }
        });

        StrategyContextV1 context2 = new StrategyContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2");
            }
        });

        log.info("subStrategyLogic1={}", context1.getClass());
        context1.execute();
        log.info("subStrategyLogic2={}", context2.getClass());
        context2.execute();

    }


}
