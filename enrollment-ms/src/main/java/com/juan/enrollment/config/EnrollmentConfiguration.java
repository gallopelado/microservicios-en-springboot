package com.juan.enrollment.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EnrollmentConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.registerModule(new RecordModule());
        return modelMapper;
    }

    /*@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
