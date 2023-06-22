// Generated by delombok at Tue Jun 20 17:11:51 CST 2023
package com.example.delombok.controller.dev;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
public class DevDevelopmentController {
    @java.lang.SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DevDevelopmentController.class);

    @GetMapping
    public String testMessage() {
        return "Hello!";
    }

    @PostMapping
    public Object testResponse(@RequestBody @NotNull Object body) {
        return body;
    }
}