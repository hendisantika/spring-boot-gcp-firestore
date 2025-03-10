package id.my.hendisantika.gcpfirestore.repository;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import id.my.hendisantika.gcpfirestore.document.User;
import reactor.core.publisher.Flux;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-gcp-firestore
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 11/03/25
 * Time: 05.11
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends FirestoreReactiveRepository<User> {

    Flux<User> findByCountry(String country);
}
