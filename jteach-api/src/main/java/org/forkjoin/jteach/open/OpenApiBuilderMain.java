package org.forkjoin.jteach.open;

import org.forkjoin.apikit.Analyse;
import org.forkjoin.apikit.Context;
import org.forkjoin.apikit.Manager;
import org.forkjoin.apikit.ObjectFactory;
import org.forkjoin.apikit.generator.JavaClientGenerator;
import org.forkjoin.apikit.impl.JdtAnalyse;
import org.forkjoin.apikit.jgit.GitGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;


public class OpenApiBuilderMain {
    private static final Logger log = LoggerFactory.getLogger(OpenApiBuilderMain.class);

    /**
     *
     */
    public static void main(String[] args) throws Exception {
        final String version = "v1";
        File root = new File("jteach-api");
        if (!root.exists()) {
            root = new File("jteach/jteach-api");
        }


        File dir = new File(root, "src/main/java/");
        File javaClientDir = new File(root, "src/test/java/");
//        File jsClientDir = new File(root, "src/test/js/");


        // TODO 修改下面的乱七八糟的路径
        log.info("代码路径:{}", dir.getAbsolutePath());


        Manager manager = new Manager();
        manager.setPath(dir.getAbsolutePath());
        manager.setRootPackage("org.forkjoin.jteach.open");
        manager.setObjectFactory(objectFactory);

        //开始处理
        manager.analyse();

        {
            JavaClientGenerator generator = new JavaClientGenerator();
            generator.setOutPath(javaClientDir.getAbsolutePath());
            generator.setVersion(version);
            generator.setRootPackage("org.forkjoin.jteach.open.client");
            manager.generate(generator);
        }


        if (false) {
            GitGenerator gitGenerator = new GitGenerator();

            JavaClientGenerator generator = new JavaClientGenerator();
            generator.setVersion(version);
            String rootPackage = "com.lipspay.cloud.sdk.client";
            generator.setRootPackage(rootPackage);

            gitGenerator.setGenerator(generator);
            gitGenerator.setGitUrl("https://code.aliyun.com/lipscoffee/cloud-sdk.git");
            gitGenerator.setGitUser("zuoge85");
            gitGenerator.setGetPassword("sbfgfg03423");
            gitGenerator.setGitEmail("zuoge85@gmail.com");
            gitGenerator.setGitName("小草");

            gitGenerator.setSrcUri("javasdk/src/main/java");
            gitGenerator.setDeleteUris(Arrays.asList(rootPackage.replace(".", "/")));
            gitGenerator.setGitBranch("master");

            manager.generate(gitGenerator);
        }

//        {
//            JavaScriptGenerator generator = new JavaScriptGenerator();
//            generator.setOutPath(jsClientDir.getAbsolutePath());
//            generator.setVersion(version);
//            manager.generate(generator);
//        }
    }

    private static ObjectFactory objectFactory = new ObjectFactory() {
        @Override
        public Analyse createAnalyse() {
            return new JdtAnalyse();
        }

        @Override
        public Context createContext() {
            return new Context();
        }
    };
}
