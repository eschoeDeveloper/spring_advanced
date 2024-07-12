package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;

public interface OrderServiceV2 {
    void orderItem(TraceId traceId, String itemId);
}
