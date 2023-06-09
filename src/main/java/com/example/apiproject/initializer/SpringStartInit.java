package com.example.apiproject.initializer;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringStartInit {
    @PostConstruct
    public void init() throws Exception {
        log.info(getClass().getName());
    }
}
