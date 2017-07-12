package org.forkjoin.jteach.core.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * @author zuoge85@gmail.com on 2017/6/8.
 */
public class EmbededRedis {
    @Value("${spring.datasource.embeded}")
    private boolean embeded;

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void start() throws IOException {
        if (embeded) {
            redisServer = new RedisServer(redisPort);
            redisServer.start();
        }
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }
}
