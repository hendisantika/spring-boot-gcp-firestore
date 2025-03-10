package id.my.hendisantika.gcpfirestore.service;

import id.my.hendisantika.gcpfirestore.document.User;
import id.my.hendisantika.gcpfirestore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> delete(String id) {
        return this.userRepository
                .findById(id).flatMap(p ->
                        this.userRepository
                                .deleteById(p.getId())
                                .thenReturn(p));
    }

    public Mono<User> update(String id, User user) {
        return this.userRepository.findById(id)
                .flatMap(u -> {
                    u.setId(id);
                    u.setEmail(user.getEmail());
                    u.setName(user.getName());
                    u.setCountry(user.getCountry());
                    return save(u);
                }).switchIfEmpty(Mono.empty());
    }
}
