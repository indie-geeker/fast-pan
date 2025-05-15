package com.indiegeeker.pan.server.modules.test.controller;

import com.indiegeeker.pan.core.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public R test(){
        return R.success("test success!");
    }
}

