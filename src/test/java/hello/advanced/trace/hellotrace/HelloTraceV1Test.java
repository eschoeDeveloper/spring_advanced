package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {

    @Test
    void begin_end() {

        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello World");
        trace.end(status);

    }

    @Test
    void begin_end_v2() {

        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("Hello World");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "Hello World 2");

        trace.end(status2);
        trace.end(status);

    }

    @Test
    void begin_exception() {

        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello World");
        trace.exception(status, new IllegalStateException());

    }

    @Test
    void begin_exception_v2() {

        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("Hello World");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "Hello World 2");

        trace.exception(status2, new IllegalStateException());
        trace.exception(status, new IllegalStateException());

    }

}
