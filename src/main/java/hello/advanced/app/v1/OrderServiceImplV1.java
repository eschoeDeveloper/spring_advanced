package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImplV1 implements OrderServiceV1 {

    private final OrderRepositoryV1 repository;
    private final HelloTraceV1 helloTraceV1;

    @Override
    public void orderItem(String itemId) {

        TraceStatus status = null;

        try {
            status = helloTraceV1.begin("OrderService.v1.request");
            repository.save(itemId);
            helloTraceV1.end(status);
        } catch (Exception e) {
            helloTraceV1.exception(status, e);
            throw e; // 예외를 다시 던져준다. -> 커스텀 예외처리 이므로, 반환해주지 않으면 정상으로 되버린다.
        }

    }

}
