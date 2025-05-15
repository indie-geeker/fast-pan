package com.indiegeeker.pan.framework.springdoc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringDoc 配置属性类
 * <p>
 * 该类用于绑定 application.yaml 中的 springdoc 相关配置，
 * 提供了类型安全的属性访问方式。
 * </p>
 *
 * @author indiegeeker
 * @date 2025-05-15
 */
@Component
@ConfigurationProperties(prefix = "springdoc")
@Data
public class SpringDocProperties {

    /**
     * API 文档配置
     */
    private ApiDocs apiDocs = new ApiDocs();

    /**
     * Swagger UI 配置
     */
    private SwaggerUi swaggerUi = new SwaggerUi();

    /**
     * 需要扫描的包路径
     */
    private String packagesToScan;

    /**
     * 缓存配置
     */
    private Cache cache = new Cache();

    /**
     * 默认生成的媒体类型
     */
    private String defaultProducesMediaType;

    /**
     * 分组配置列表
     */
    private List<GroupConfig> groupConfigs = new ArrayList<>();

    /**
     * API 文档配置类
     */
    @Data
    public static class ApiDocs {
        /**
         * 是否启用 API 文档，默认为 true
         */
        private boolean enabled = true;

        /**
         * API 文档的访问路径，默认为 /v3/api-docs
         */
        private String path = "/api-doc";
    }

    /**
     * Swagger UI 配置类
     */
    @Data
    public static class SwaggerUi {
        /**
         * Swagger UI 的访问路径，默认为 /swagger-ui.html
         */
        private String path = "/swagger-ui.html";

        /**
         * 标签排序方式，可选值：alpha（字母顺序）
         */
        private String tagsSorter = "alpha";

        /**
         * 操作排序方式，可选值：alpha（字母顺序）
         */
        private String operationsSorter = "alpha";

        /**
         * 是否禁用默认的 Swagger URL
         */
        private boolean disableSwaggerDefaultUrl = true;

        /**
         * 是否启用 "Try it out" 功能
         */
        private boolean tryItOutEnabled = true;
    }

    /**
     * 缓存配置类
     */
    @Data
    public static class Cache {
        /**
         * 是否禁用缓存，默认为 false（启用缓存）
         */
        private boolean disabled = false;
    }

    /**
     * 分组配置类
     */
    @Data
    public static class GroupConfig {
        /**
         * 分组名称
         */
        private String group;

        /**
         * 匹配的路径规则
         */
        private String pathsToMatch;

        /**
         * 需要扫描的包路径
         */
        private String packagesToScan;
    }

}
