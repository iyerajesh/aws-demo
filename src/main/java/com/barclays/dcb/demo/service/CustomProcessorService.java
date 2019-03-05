package com.barclays.dcb.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CustomProcessorService {

    @Value("${fis.baseurl}")
    private String baseURL;


    private final WebClient webClient;

    public CustomProcessorService() {

        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public Mono<String> getResult() {

        return webClient.get()
                .uri("/api")
                .retrieve()
                .bodyToMono(String.class);
    }


}