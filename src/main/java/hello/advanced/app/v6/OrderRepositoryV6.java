package hello.advanced.app.v6;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.strategy.StrategyContext;
import hello.advanced.trace.strategy.template.TraceCallback;
import hello.advanced.trace.strategy.template.TraceTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepositoryV6 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV6(LogTrace trace) {
        this.traceTemplate = new TraceTemplate(trace);
    }

    public void save(String itemId) {

        traceTemplate.execute("OrderRepository.v6.save()", new TraceCallback<>() {
            @Override
            public Void call() {
                if(itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!!");
                }
                sleep(1000);
                return null;
            }
        });

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch( InterruptedException ie ) {
            log.error("InterruptedException :: {}", ie.getMessage());
        }
    }

}
