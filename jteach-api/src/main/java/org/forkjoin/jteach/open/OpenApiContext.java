package org.forkjoin.jteach.open;

import org.forkjoin.apikit.spring.AccountHandlerInterceptor;
import org.forkjoin.apikit.spring.utils.JsonUtils;
import org.forkjoin.jteach.core.spring.boot.BootContext;
import org.forkjoin.jteach.core.spring.boot.EmbededRedis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zuoge85@gmail.com on 2017/5/16.
 */
@Configuration
public class OpenApiContext extends BootContext {

    public OpenApiContext() {
    }

    @Override
    public AccountHandlerInterceptor accountHandlerInterceptor() {
        return new OpenApiAccountHandlerInterceptor();
    }

    @Override
    public Class getAccountClass() {
        return OpenApiAccount.class;
    }

}
