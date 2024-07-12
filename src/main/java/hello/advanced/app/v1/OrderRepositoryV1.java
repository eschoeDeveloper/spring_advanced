package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 helloTraceV1;

    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = helloTraceV1.begin("OrderRepository.v1.request");
            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!!");
            }
            sleep(1000);
            helloTraceV1.end(status);
        } catch (Exception e) {
            helloTraceV1.exception(status, e);
            throw e; // 예외를 다시 던져준다. -> 커스텀 예외처리 이므로, 반환해주지 않으면 정상으로 되버린다.
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch( InterruptedException ie ) {
            log.error("InterruptedException :: {}", ie.getMessage());
        }
    }

}
