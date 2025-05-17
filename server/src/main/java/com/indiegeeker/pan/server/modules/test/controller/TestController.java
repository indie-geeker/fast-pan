package com.indiegeeker.pan.server.modules.test.controller;

import com.indiegeeker.pan.core.response.R;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TestController {

    @GetMapping("test")
    public R test(@NotBlank String name) {
        return R.success("hello " + name);
    }
}

