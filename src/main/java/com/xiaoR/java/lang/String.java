package com.xiaoR.java.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/11/4
 * @description 自定义String类, 用于演示双亲委派机制
 */
@Slf4j
public class String {
    static {
        log.warn("这是自定义的String类...");
    }
}
