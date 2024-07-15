package hello.advanced.trace.strategy;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StrategyContext {

    private final LogTrace trace;
    private final Strategy<?> strategy;

    public <T> T execute(String message) {

        TraceStatus status = null;

        try {
            status = trace.begin(message);
            T result = (T) strategy.call();
            trace.end(status);
            return result;
        } catch(Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

}
