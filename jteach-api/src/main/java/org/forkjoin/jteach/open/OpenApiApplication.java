package org.forkjoin.jteach.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author zuoge85@gmail.com on 2017/5/11.
 */

@SpringBootApplication(
        scanBasePackages = {
                "com.lipspay.cloud.open.service",
                "com.lipspay.cloud.open.listener",
                "com.lipspay.cloud.open.cache",
                "com.lipspay.cloud.open.api"
        }
)
@ServletComponentScan(basePackages = {
        "com.lipspay.cloud.open.druid",
})
@Import({
        DataSourceConfig.class, OpenApiContext.class,RedisConfig.class
})
@ImportResource("classpath*:org/forkjoin/jteach/open/db/DaoContext.xml")
@EnableWebSocket
public class OpenApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiApplication.class, args);
    }
}
