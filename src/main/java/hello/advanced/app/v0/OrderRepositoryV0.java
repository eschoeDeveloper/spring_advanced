package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {

        if(itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!!");
        }

        try {
            sleep(1000);
        } catch( InterruptedException ie ) {
            log.error("InterruptedException :: {}", ie.getMessage());
        }

    }

    private void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
