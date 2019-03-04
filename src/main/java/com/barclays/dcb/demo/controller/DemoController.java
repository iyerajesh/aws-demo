package com.barclays.dcb.demo.controller;

import com.barclays.dcb.demo.service.CustomProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    @Autowired
    private CustomProcessorService customProcessorService;

    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello");
    }

    @GetMapping("/api")
    public String getAPIResult() {
        return customProcessorService.getResult();
    }

}
