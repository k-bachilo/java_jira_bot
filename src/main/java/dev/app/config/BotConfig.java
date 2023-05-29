package dev.app.config;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import lombok.Getter;

@Singleton
@Getter
public class BotConfig {

    @Value("${telegram.bot.name}")
    String telegramBotName;

    @Value("${telegram.bot.token}")
    String telegramBotToken;

    @Value("${jira.token}")
    String jiraToken;
}
