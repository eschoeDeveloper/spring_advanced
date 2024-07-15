package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.template.TraceCallback;
import hello.advanced.trace.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     * */
    @Test
    void callbackV1() {

        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(new TraceCallback() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1");
            }
        });

        template.execute(new TraceCallback() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2");
            }
        });

    }

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     * */
    @Test
    void callbackV2() {

        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(() -> log.info("비즈니스 로직 1"));
        template.execute(() -> log.info("비즈니스 로직 2"));

    }

}
