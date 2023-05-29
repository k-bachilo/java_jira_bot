package dev.app.service;

import dev.app.exception.GlobalBusinessException;
import dev.app.model.dto.request.CreateUserRequestTO;
import dev.app.model.entity.User;
import dev.app.repository.UserRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoderService encoderService;

    public Mono<Long> addUser(CreateUserRequestTO request) {
        return Mono.fromSupplier(() -> new User(
                        request.email(),
                        request.password()
                ))
                .flatMap(userRepository::create)
                .onErrorMap(throwable -> {
                    throw new GlobalBusinessException("Error creating user");
                });

    }
}
