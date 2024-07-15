package hello.advanced.trace.strategy.template;

public interface TraceCallback<T> {
    T call();
}
