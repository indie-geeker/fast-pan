package com.indiegeeker.pan.server.common.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartedListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        String serverPort = applicationReadyEvent.getApplicationContext().getEnvironment().getProperty("server.port");
        String serverUrl = String.format("http://%s:%s", "127.0.0.1", serverPort);
        log.info(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, "fast pan server started at: ", serverUrl));
        if (checkShowSpringDoc(applicationReadyEvent.getApplicationContext())) {
            log.info(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, "fast pan server's doc started at:", serverUrl + "/doc.html"));
        }
        log.info(AnsiOutput.toString(AnsiColor.BRIGHT_YELLOW, "fast pan server has started successfully!"));
    }

    private boolean checkShowSpringDoc(ConfigurableApplicationContext applicationContext) {
        // 与 SpringDocConfig 的 @ConditionalOnProperty 保持一致，默认为 true
        return applicationContext.getEnvironment().getProperty("springdoc.api-docs.enabled", Boolean.class, true) && applicationContext.containsBean("springDocConfig");
    }
}
