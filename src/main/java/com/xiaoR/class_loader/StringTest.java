package com.xiaoR.class_loader;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/11/4
 * @description 
 */
@Slf4j
public class StringTest {
    public static void main(String[] args) {
        /**
         * 此处加载String类时, 需要从SystemClassLoader->ExtClassLoader->BootstrapClassLoader逐层寻找,
         * 由于BootstrapClassLoader负责加载java.lang包, 所以其会加载java核心类库的String类,
         * 而不会加载用于自定义的与java.lang.String同包同名的类.
         * (当上层加载器无法找到对应的类时, 才会回到下层加载器进行加载: SystemClassLoader<-ExtClassLoader<-BootstrapClassLoader)
         */
        java.lang.String str = new java.lang.String();
        log.info("StringTest main...");

        StringTest stringTest = new StringTest();
        log.debug("StringTest ClassLoader: {}", stringTest.getClass().getClassLoader());    // sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
