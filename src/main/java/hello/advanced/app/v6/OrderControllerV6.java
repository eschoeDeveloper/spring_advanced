package hello.advanced.app.v6;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.strategy.StrategyContext;
import hello.advanced.trace.strategy.template.TraceCallback;
import hello.advanced.trace.strategy.template.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV6 {

    private final OrderServiceV6 orderService;
    private final TraceTemplate traceTemplate;

    public OrderControllerV6( OrderServiceV6 orderService, LogTrace trace ) {
        this.orderService = orderService;
        this.traceTemplate = new TraceTemplate(trace);
    }

    @GetMapping("/v6/request")
    public String request(String itemId) {

        return traceTemplate.execute("OrderController.v6.request", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "complete";
            }
        });

    }

}
