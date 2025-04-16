package com.mateusz113.git_hub_proj.git_hub_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class GitProjectConfig {
    @Bean
    public Clock getClock() {
        return Clock.systemUTC();
    }
}
