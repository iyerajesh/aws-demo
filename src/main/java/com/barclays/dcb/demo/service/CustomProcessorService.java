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

    @Value("${fis.baseUrl}")
    private String baseURL;

    @Bean
    WebClient client() {
        return WebClient.create(baseURL);
    }

    private Mono<ClientResponse> result = client().get()
            .uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    public String getResult() {
        return result.flatMap(res -> res.bodyToMono(String.class)).block();
    }


}