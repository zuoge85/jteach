package org.forkjoin.jteach.core.spring.boot;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.Sources;
import com.wix.mysql.config.DownloadConfig;
import com.wix.mysql.config.DownloadConfigBuilder;
import com.wix.mysql.config.MysqldConfig;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;

/**
 * @author zuoge85@gmail.com on 2017/6/8.
 */
public class EmbededMysql {
    @Value("${spring.datasource.embeded}")
    private boolean embeded;

    @Value("${spring.datasource.port}")
    private int mysqlPort;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.embededSchema}")
    private String embededSchema;

    private EmbeddedMysql mysqld;

    @PostConstruct
    public void start() throws IOException {
        if (embeded) {

            //http://mirrors.ctyun.cn/Mysql/
            DownloadConfig downloadConfig = DownloadConfig.aDownloadConfig().withBaseUrl("http://mirrors.sohu.com/mysql/").build();

            MysqldConfig config = aMysqldConfig(v5_7_latest)
                    .withCharset(UTF8)
                    .withPort(mysqlPort)
                    .withUser(username, password)
                    .withTimeout(2, TimeUnit.MINUTES)
                    .withTempDir(System.getProperty("java.io.tmpdir"))
                    .withServerVariable("max_connect_errors", 666)
                    .build();


            mysqld = anEmbeddedMysql(config,downloadConfig)
                    .addSchema(embededSchema )
                    .start();
        }
    }

    @PreDestroy
    public void stopRedis() {
        if (mysqld != null) {
            mysqld.stop();
        }
    }
}
