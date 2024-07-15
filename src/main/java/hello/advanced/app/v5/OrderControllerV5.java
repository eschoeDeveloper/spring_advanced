package hello.advanced.app.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.strategy.StrategyContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(String itemId) {

        StrategyContext strategy = new StrategyContext(trace, new Strategy<String>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "complete";
            }
        });

        return strategy.execute("OrderController.v4.request");

    }

}
