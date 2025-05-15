package com.indiegeeker.pan.framework.springdoc.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc 配置类
 * <p>
 * 该配置类用于设置 SpringDoc OpenAPI 文档的全局配置，包括文档基本信息、
 * 安全配置、外部文档链接等。通过该配置，可以自定义 API 文档的展示方式和内容。
 * </p>
 *
 * @author indiegeeker
 * @date 2025-05-15
 */
@Configuration
@ConditionalOnProperty(name = "springdoc.api-docs.enabled", havingValue = "true", matchIfMissing = true)
public class SpringDocConfig {

    @Value("${spring.application.name:Fast-Pan}")
    private String applicationName;

    /**
     * 配置 OpenAPI 对象
     * <p>
     * 该 Bean 定义了 API 文档的基本信息，包括标题、描述、版本、联系方式、
     * 许可证信息以及外部文档链接等。
     * </p>
     *
     * @return OpenAPI 对象
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                // 设置文档基本信息
                .info(new Info()
                        .title(applicationName + " API 文档")
                        .description("Fast-Pan 网盘系统 API 文档")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("IndieGeeker")
                                .url("https://github.com/indie-geeker")
                                .email("contact@indiegeeker.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                // 设置外部文档
                .externalDocs(new ExternalDocumentation()
                        .description("Fast-Pan 项目文档")
                        .url("https://github.com/indie-geeker/fast-pan"))
                // 添加全局安全配置
                .addSecurityItem(new SecurityRequirement().addList("Bearer"))
                // 定义安全方案
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                                        .description("JWT 认证，请在此输入 Bearer token")));
    }

    /**
     * 配置用户模块 API 分组
     * <p>
     * 通过 GroupedOpenApi 可以将 API 按模块或功能进行分组，
     * 使文档结构更加清晰。
     * </p>
     *
     * @return 用户模块 API 分组
     */
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("用户模块")
                .pathsToMatch("/user/**")
                .packagesToScan("com.indiegeeker.pan.server.modules.user")
                .build();
    }

    /**
     * 配置文件模块 API 分组
     *
     * @return 文件模块 API 分组
     */
    @Bean
    public GroupedOpenApi fileApi() {
        return GroupedOpenApi.builder()
                .group("文件模块")
                .pathsToMatch("/file/**")
                .packagesToScan("com.indiegeeker.pan.server.modules.file")
                .build();
    }

    /**
     * 配置分享模块 API 分组
     *
     * @return 分享模块 API 分组
     */
    @Bean
    public GroupedOpenApi shareApi() {
        return GroupedOpenApi.builder()
                .group("分享模块")
                .pathsToMatch("/share/**")
                .packagesToScan("com.indiegeeker.pan.server.modules.share")
                .build();
    }

    /**
     * 配置测试模块 API 分组
     *
     * @return 测试模块 API 分组
     */
    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder()
                .group("测试模块")
                .pathsToMatch("/test/**")
                .packagesToScan("com.indiegeeker.pan.server.modules.test")
                .build();
    }
}
