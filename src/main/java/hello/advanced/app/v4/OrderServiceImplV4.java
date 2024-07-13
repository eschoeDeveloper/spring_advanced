package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImplV4 implements OrderServiceV4 {

    private final OrderRepositoryV4 repository;
    private final LogTrace trace;

    @Override
    public void orderItem(String itemId) {


        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                repository.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.v4.orderItem()");

    }

}
