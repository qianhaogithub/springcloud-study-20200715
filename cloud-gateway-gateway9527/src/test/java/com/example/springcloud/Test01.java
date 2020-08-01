package com.example.springcloud;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author qianhao
 * @create 2020/7/30-23:37
 */
public class Test01 {

    @Test
    public void test01() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
