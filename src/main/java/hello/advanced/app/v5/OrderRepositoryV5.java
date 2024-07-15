package hello.advanced.app.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.strategy.StrategyContext;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {

    private final LogTrace trace;

    public void save(String itemId) {

        StrategyContext strategy = new StrategyContext(trace, new Strategy<Void>() {
            @Override
            public Void call() {
                if(itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!!");
                }
                sleep(1000);
                return null;
            }
        });

        strategy.execute("OrderRepository.v5.save()");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch( InterruptedException ie ) {
            log.error("InterruptedException :: {}", ie.getMessage());
        }
    }

}
