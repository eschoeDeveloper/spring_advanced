package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 helloTraceV1;

    @GetMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = helloTraceV1.begin("OrderController.v1.request");
            orderService.orderItem(itemId);
            helloTraceV1.end(status);
            return "complete";
        } catch (Exception e) {
            helloTraceV1.exception(status, e);
            throw e; // 예외를 다시 던져준다. -> 커스텀 예외처리 이므로, 반환해주지 않으면 정상으로 되버린다.
        }

    }

}
