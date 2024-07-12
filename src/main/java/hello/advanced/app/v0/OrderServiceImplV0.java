package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImplV0 implements OrderServiceV0 {

    private final OrderRepositoryV0 repository;

    @Override
    public void orderItem(String itemId) {
        repository.save(itemId);
    }

}
