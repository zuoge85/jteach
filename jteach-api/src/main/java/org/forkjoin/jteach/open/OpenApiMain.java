package org.forkjoin.jteach.open;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class OpenApiMain {

    public static final void main(String... args) {
        try {
            File dir = new File("lib");
            URLClassLoader cl = (URLClassLoader) ClassLoader.getSystemClassLoader();
            if (dir.exists()) {
                File[] fileArray = dir.listFiles();

                Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                addURL.setAccessible(true);
                for (File file : fileArray) {
                    addURL.invoke(cl, file.toURI().toURL());
                }
            }
            OpenApiApplication.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
