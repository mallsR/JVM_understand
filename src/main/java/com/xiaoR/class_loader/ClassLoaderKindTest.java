package com.xiaoR.class_loader;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/10/31
 * @description 用于演示类加载器的种类及其关系
 */
@Slf4j
public class ClassLoaderKindTest {
    public static void main(String[] args) {
        log.info("*********************类加载器种类及其关系*********************");
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        log.info("系统类加载器: {}", systemClassLoader);  // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取得上层: 扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        log.info("扩展类加载器: {}", extClassLoader);     // sun.misc.Launcher$ExtClassLoader@5b6f7412

        // 获取上层: 启动类加载器 [实际情况: 无法获取bootstrapClassLoader]
        // bootstrapClassLoader 使用C/C++编写, 无法拿到
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        log.info("启动类加载器: {}", bootstrapClassLoader);       // null

        // 对于用户自定义类来说: 默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderKindTest.class.getClassLoader();
        log.info("自定义类加载器: {}", classLoader);   // sun.misc.Launcher$AppClassLoader@18b4aac2

        // String类使用引导类加载器进行加载 --> Java的核心类库都是通过引导类加载器进行加载
        ClassLoader stringClassLoader = String.class.getClassLoader();
        log.info("String类加载器: {}", stringClassLoader);  // null


        log.info("==========================================");


        // 获取启动类加载器能加载的api的路径
        log.info("*********************启动类加载器*********************");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            log.info("{}", url.toExternalForm());
        }
        // 从上面的路径中随机选择一个类, 看看他的类加载器是什么: 引导类加载器
        ClassLoader classLoader1 = Provider.class.getClassLoader();
        log.info("Provider类加载器: {}", classLoader1); // null

        // 获取扩展类加载器能加载的api的路径
        log.info("*********************扩展类加载器*********************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            log.info("{}", path);
        }

        // 从上面的路径中随便选一个类, 看看他的类加载器是什么: 扩展类加载器
        ClassLoader classLoader2 = CurveDB.class.getClassLoader();
        log.info("CurveDB类加载器: {}", classLoader2);

    }
}
