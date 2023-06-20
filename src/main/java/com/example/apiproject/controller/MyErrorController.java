package com.example.apiproject.controller;

import com.example.delombok.domain.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public Result error() {
        return Result.error("error from " + getClass().getName());
    }
}