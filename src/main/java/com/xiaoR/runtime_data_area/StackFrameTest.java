package com.xiaoR.runtime_data_area;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/11/4
 * @description
 */
@Slf4j
public class StackFrameTest {
    public static void main(String[] args) {
        /**
         * 变量的分类:
         *   按照数据类型分: 基本数据类型, 引用数据类型
         *   按照在类中声明的位置分:
         *          局部变量: 在使用前,必须要进行显式赋值! 否则,编译不通过
         *          成员变量: 在使用前,都经历默认初始化赋值
         *              类变量: linking的prepare阶段: 给类变量默认赋值 --> initial阶段: 给类变量显式赋值
         *              实例变量: 随着对象的创建,会在堆空间中分配实例变量空间,并进行默认赋值
         *
         */
        int num;    // 局部变量,
        log.info("num: {}", num);   // 不进行显式赋值, 编译不通过
    }
}
