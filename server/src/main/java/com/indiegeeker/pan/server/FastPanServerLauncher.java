package com.indiegeeker.pan.server;

import com.indiegeeker.pan.core.constants.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = Constants.BASE_COMPONENT_SCAN_PATH)
@ServletComponentScan(basePackages = Constants.BASE_COMPONENT_SCAN_PATH)
public class FastPanServerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(FastPanServerLauncher.class, args);
    }
}
