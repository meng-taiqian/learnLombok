package com.qkh.mapper;

import com.qkh.entity.MyBean;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingDao {
    public MyBean greeting() {
        MyBean bean = new MyBean();
        bean.setFiledOne("Hello Mr.Qiu!!!!");
        return bean;
    }
}
