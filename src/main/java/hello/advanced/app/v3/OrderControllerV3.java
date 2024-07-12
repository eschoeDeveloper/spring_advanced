package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderController.v3.request");
            orderService.orderItem(itemId);
            trace.end(status);
            return "complete";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 다시 던져준다. -> 커스텀 예외처리 이므로, 반환해주지 않으면 정상으로 되버린다.
        }

    }

}
