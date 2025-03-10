package id.my.hendisantika.gcpfirestore.service;

import id.my.hendisantika.gcpfirestore.document.Order;
import id.my.hendisantika.gcpfirestore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-gcp-firestore
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 11/03/25
 * Time: 05.29
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Mono<Order> createOrder(Order order) {
        // Set the creation time
        order.setTimestamp(LocalDateTime.now());

        // Children are saved in cascade.
        return orderRepository.save(order);
    }
}
