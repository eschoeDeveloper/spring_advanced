package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {

        StrategyContextV2 context = new StrategyContextV2();

        context.execute(new SubStrategyLogic1());
        context.execute(new SubStrategyLogic2());

    }


}
