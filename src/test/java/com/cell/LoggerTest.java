package com.cell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ${aimimi2015} on 2018/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerTest.class);



    @Test
    public void test1(){
        String name = "aimii";
        String password ="123456";
        log.debug("debug...");
        log.info("name:"+name+", passwprd"+password);
        log.info("name:{},passwprd:{}",name,password);
        log.error("error...");
    }
}

