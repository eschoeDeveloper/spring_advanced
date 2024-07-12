package hello.advanced.app.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.v3.save()");
            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
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
