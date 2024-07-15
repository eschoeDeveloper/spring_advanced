package hello.advanced.app.v6;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.strategy.StrategyContext;
import hello.advanced.trace.strategy.template.TraceCallback;
import hello.advanced.trace.strategy.template.TraceTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImplV6 implements OrderServiceV6 {

    private final OrderRepositoryV6 repository;
    private final TraceTemplate traceTemplate;

    public OrderServiceImplV6(OrderRepositoryV6 repository, LogTrace logTrace) {
        this.repository = repository;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    @Override
    public void orderItem(String itemId) {

        traceTemplate.execute("OrderService.v6.orderItem()", new TraceCallback<>() {
            @Override
            public Void call() {
                repository.save(itemId);
                return null;
            }
        });

    }

}
