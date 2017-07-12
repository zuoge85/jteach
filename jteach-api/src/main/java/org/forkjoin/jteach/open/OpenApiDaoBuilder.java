package org.forkjoin.jteach.open;

import org.forkjoin.db.Builder;
import org.forkjoin.jteach.core.spring.boot.EmbededMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author zuoge85@gmail.com on 2017/5/23.
 */

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(pattern = ".*", type = FilterType.REGEX))
@Import(DataSourceConfig.class)
@Configuration
public class OpenApiDaoBuilder implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OpenApiDaoBuilder.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
    }

    @Bean
    public EmbededMysql EmbededMysql() {
        return new EmbededMysql();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... strings) throws Exception {
        File root = new File("jteach-api");
        if (!root.exists()) {
            root = new File("jteach/jteach-api");
        }
        Builder builder = new Builder(
                root, dataSource, "org.forkjoin.jteach.open.db"
        );
        builder.build();
    }
}
