package com.example.demo.repository;

import com.example.demo.model.Tutorial;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TutorialRepository extends R2dbcRepository<Tutorial, Integer> {
    Flux<Tutorial> findByTitleContaining(String title);

    Flux<Tutorial> findByPublished(boolean isPublished);

    @Query("insert into tutorial(id, title, description, published) values($1, $2, $3, $4) " +
            "on conflict(id) do update set title = $2, description = $3, published = $4")
    Mono<Integer> insertFin(int id, String title, String description, boolean published);
}