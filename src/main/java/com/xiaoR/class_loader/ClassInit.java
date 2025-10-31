package com.xiaoR.class_loader;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/10/31
 * @description 演示类加载器中Initialization过程的原理
 */
@Slf4j
public class ClassInit {
    /**
     * 一个必定有一个构造方法, 所以其对应的字节码文件的方法中一定拥有一个<init>方法
     */
    private int num1 = 10;
    public ClassInit() {
        num1 = 20;
        int num2 = 20;
    }

    /**
     * 类中至少定义了一个静态变量, 才会在类对应的字节码文件中, 生成一个<clinit>方法
     */
    private static int s_num = 1;

    static {
        log.info("ClassInit static block");
        s_num = 2;
        s_number = 20;
        log.info("ClassInit static block num: {}", s_num);
//        log.info("ClassInit static block number: {}", number);  // 报错: 非法的前向引用
    }

    /**
     * 在类加载器的Linking阶段中, prepare步骤会自动将静态变量number = 0,
     * 然后在initial阶段, 先将number = 20, 然后再将number = 10
     */
    private static int s_number = 10;

    public static void main(String[] args) {
        log.info("ClassInit main num: {}", s_num);
        log.info("ClassInit main number: {}", s_number);
    }
}
