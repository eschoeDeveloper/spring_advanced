package hello.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    // 동시성 과정 확인 테스트
    @Test
    void field() {

        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        Thread threadB = new Thread(userB);

        threadA.setName("thread-A");
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제 발생 안함.
        sleep(100); // 처리중에 진입하므로 동시성 이슈를 유발한다.
        threadB.start();
//        sleep(3000); // 메인 쓰레드 종료 대기.
        sleep(2000);

        log.info("main exit");

//        Thread threadA = new Thread(() -> {
//            fieldService.logic("userA");
//        });
//        Thread threadB = new Thread(() -> {
//            fieldService.logic("userB");
//        });

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch( InterruptedException ie ) {
            log.error("InterruptedException :: {}", ie.getMessage());
        }
    }

}
