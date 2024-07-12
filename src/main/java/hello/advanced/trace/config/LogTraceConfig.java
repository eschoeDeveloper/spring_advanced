package hello.advanced.trace.config;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    // Singleton Bean으로 등록
    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }

}
