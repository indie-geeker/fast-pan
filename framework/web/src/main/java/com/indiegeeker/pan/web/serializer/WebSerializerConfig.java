package com.indiegeeker.pan.web.serializer;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author leo
 * @date 2025/5/15 16:30
 * @description:
 */
@Configuration
public class WebSerializerConfig {
    @Bean
    public SimpleModule customSerializerModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new Date2StringSerializer());
        module.addSerializer(Long.class, new IdEncryptSerializer());
        return module;
    }
}