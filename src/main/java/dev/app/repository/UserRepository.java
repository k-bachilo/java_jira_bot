package dev.app.repository;

import dev.app.model.entity.User;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Objects;

@Singleton
@RequiredArgsConstructor
public class UserRepository {
    private final DSLContext jooq;
    private final Scheduler scheduler = Schedulers.boundedElastic();



    public Mono<Long> create(User user) {
        return Mono.fromCallable(() -> user)
                .map(it -> jooq.newRecord(USERS, it))
                .mapNotNull(usersRecord -> (jooq.insertInto(USERS))
                                .set(usersRecord)
                                .returning()
                                .fetchOne())
                        .getValue(USERS.ID))
                .subscribeOn(scheduler);
    }
}
