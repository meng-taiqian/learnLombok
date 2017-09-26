package com.qkh.service;

@FunctionalInterface
public interface HellowService {
    default void sayHello(){
        System.out.println("Hello, Mr.s%!");
    }

    static void sayBye(){
        System.out.println("Good bye, Mr.s%");
    }

    default String getName(){
        return "s%";
    }

    void sayGoodBye();

}
