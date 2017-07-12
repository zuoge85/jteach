package org.forkjoin.jteach.open;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.forkjoin.jteach.open.client.ApiManager;
import org.forkjoin.apikit.client.HttpClientAdapter;
import org.forkjoin.apikit.client.OkHttpClientAdapter;
import org.forkjoin.apikit.client.core.JacksonJsonConvert;
import org.forkjoin.apikit.client.core.JsonConvert;
import org.forkjoin.apikit.client.core.TypeConvert;
import org.forkjoin.apikit.spring.client.MockHttpClientAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.ConversionService;

/**
 * @author zuoge85@gmail.com on 2017/5/15.
 */
@Configuration
public class TestsContext {
    private int port = 8081;

    @Bean
    public ApiManager apiManager(HttpClientAdapter httpClientAdapter) {
        return new ApiManager(httpClientAdapter);
    }

    @Profile("mock")
    @Bean(destroyMethod = "close")
    public HttpClientAdapter mockHttpClientAdapter(TypeConvert typeConvert, org.forkjoin.apikit.client.core.JsonConvert jsonConvert) {
        return new MockHttpClientAdapter("http://127.0.0.1:"+port+"/v1/", typeConvert, jsonConvert);
    }

    @Profile("remote")
    @Bean(destroyMethod = "close")
    public HttpClientAdapter remoteHttpClientAdapter(TypeConvert typeConvert, org.forkjoin.apikit.client.core.JsonConvert jsonConvert) {
        return new OkHttpClientAdapter(
                "http://127.0.0.1:"+8080+"/v1/", typeConvert, jsonConvert
        );
    }

    @Bean
    public TypeConvert typeConvert(final ConversionService conversionService) {
        return new TypeConvert() {
            @Override
            public String convert(Object source) {
                return conversionService.convert(source, String.class);
            }
        };
    }

    @Bean
    public JsonConvert jsonConvert(ObjectMapper mapper) {
        return new JacksonJsonConvert(mapper);
    }

}
