package com.indiegeeker.pan.framework.springdoc.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * SpringDoc 自动配置类
 * <p>
 * 该配置类用于自动加载 SpringDoc 相关配置，通过 Spring Boot 的自动配置机制，
 * 将 SpringDocConfig 中的配置自动注入到应用上下文中。
 * </p>
 *
 * @author indiegeeker
 * @date 2025-05-15
 */
@AutoConfiguration
@Import(SpringDocConfig.class)
@ComponentScan("com.indiegeeker.pan.framework.springdoc")
public class SpringDocAutoConfiguration {
    // 自动配置类，无需额外代码
}
