package hello.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    public void templateMethodV0() {

        logic1();
        logic2();

    }

    private void logic1() {

        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }

    /**
     * 템플릿 메서드 패턴 적용
     * */
    @Test
    void templateMethodV1() {

        AbstractTemplate template = new SubClassLogic1();
        AbstractTemplate template2 = new SubClassLogic2();

        template.execute();
        template2.execute();

    }

    /**
     * 템플릿 메서드 패턴 적용
     * */
    @Test
    void templateMethodV2() {

        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        AbstractTemplate template2 = new AbstractTemplate(){
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        log.info("클래스 이름1={}", template.getClass());
        template.execute();
        log.info("클래스 이름2={}", template2.getClass());
        template2.execute();

    }

}
