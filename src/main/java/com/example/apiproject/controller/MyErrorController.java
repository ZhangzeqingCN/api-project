package com.example.apiproject.controller;

import com.example.apiproject.domain.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "MyErrorController", description = "Error相关接口控制器")
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    @Operation(summary = "返回错误", description = "返回错误信息、位置")
    public Result error() {
        return Result.error("error from " + getClass().getName());
    }
}