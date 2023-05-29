package dev.app.client;

import dev.app.model.dto.response.AllTaskResponseTO;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Client(id = "JIRA")
@Header(name = USER_AGENT, value = "JIRA Bot")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface JiraClient {

    @Get("/repos/${github.organization}/${github.repo}/releases")
    Mono<AllTaskResponseTO> getAllCurrentTasks();

    @Get("/repos/${github.organization}/${github.repo}/releases")
    Mono<Void> logWork(String issueKey, String timeSpent);
}
