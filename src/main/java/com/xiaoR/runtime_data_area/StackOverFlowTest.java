package com.xiaoR.runtime_data_area;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/11/4
 * @description 演示栈溢出的情况
 *              默认情况下: count = 9787;
 *              设置栈的大小: 在Run->Edit Configuration->VM Options添加参数Xss128k
 */
@Slf4j
public class StackOverFlowTest {
    private static int count = 0;
    public static void main(String[] args) {
        log.info("第 {} 次入栈...", ++count);
        main(args);
    }
}
