package hello.advanced.app.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.strategy.StrategyContext;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImplV5 implements OrderServiceV5 {

    private final OrderRepositoryV5 repository;
    private final LogTrace trace;

    @Override
    public void orderItem(String itemId) {

        StrategyContext strategy = new StrategyContext(trace, new Strategy<Void>() {
            @Override
            public Void call() {
                repository.save(itemId);
                return null;
            }
        });

        strategy.execute("OrderService.v4.orderItem()");

    }

}
