package dev.app.properties;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import lombok.Getter;

@Singleton
@Getter
public class BotPropertiesComponent {
    @Value("${jira.url}")
    private String jiraUrl;
}
