package dev.app;

import io.micronaut.runtime.Micronaut;

public class JiraBotApplication {

    public static void main(String[] args) {
        System.setProperty("org.jooq.no-tips", "true");
        System.setProperty("org.jooq.no-logo", "true");
        Micronaut.run(JiraBotApplication.class, args);
    }
}