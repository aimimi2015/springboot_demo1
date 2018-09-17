package com.demo;


import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by ${aimimi2015} on 2018/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void test1() {
        String name = "aimii";
        String password = "123456";
        log.debug("debug...");
        log.info("name:" + name + ", passwprd" + password);
        log.info("name:{},passwprd:{}", name, password);
        log.error("error...");
    }

    @Test
    public void test2() {
        Long time = new Date().getTime();
        Long time1 = new DateTime().getMillis();
        Date time3 = new DateTime().toDate();
        DateTime time4 = new DateTime().toDateTime();
        log.info(String.valueOf(time));
        log.info(String.valueOf(time1));
        log.info(String.valueOf(time3));
        log.info(String.valueOf(time4));


    }


}

