package com.user.service.config;


import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FlywayConfig {

    //@Bean
    public FlywayMigrationStrategy getFlywayStrategy() {
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }
}
