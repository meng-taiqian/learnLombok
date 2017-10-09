package com.qkh.service;

import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface HellowService {
    default void sayHello(){
        LoggerFactory.getLogger(HellowService.class).info("Hello, Mr.s%!");
    }

    static void sayBye(){
        LoggerFactory.getLogger(HellowService.class).info("Good bye, Mr.s%");
    }

    default String getName(){
        return "AAA s%";
    }

    void sayGoodBye();

}
