package com.example.apiproject.controller.dev;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
@Slf4j
@Tag(name = "DevDevelopmentController", description = "DevDevelopmentController")
public class DevDevelopmentController {

    @GetMapping
    public String testMessage() {
        return "Hello!";
    }

    @PostMapping
    public Object testResponse(@RequestBody @NotNull Object body) {
        return body;
    }
}
