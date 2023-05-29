package dev.app.service;

import dev.app.model.dto.request.AddTaskToFavouritesRequestTO;
import dev.app.model.dto.response.FavouriteTaskResponseTO;
import io.micronaut.caffeine.cache.Cache;
import io.micronaut.caffeine.cache.Caffeine;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Singleton
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    public void addToFavourites(AddTaskToFavouritesRequestTO requestTO) {


        favourites.get(userId, key -> new ArrayList<>()).add(task);

    }

    public Mono<FavouriteTaskResponseTO> getFavourites(){
        Cache<String, List<FavouriteTaskResponseTO>> favourites = Caffeine
                .newBuilder()
                .build();

        favourites.getIfPresent(userId);
        if (favourites == null){
            log.info("For user with id {} no favourites tasks", );
        } else {
            favourites.
        }
    }
}
