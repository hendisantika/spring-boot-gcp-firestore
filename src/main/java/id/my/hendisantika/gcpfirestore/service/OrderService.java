package id.my.hendisantika.gcpfirestore.service;

import id.my.hendisantika.gcpfirestore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
