package com.qkh.service;

import com.qkh.dao.GreetingDao;
import com.qkh.entity.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements HellowService{

    @Autowired
    private GreetingDao dao;

    public MyBean greeting()
    {
        return dao.greeting();
    }

    public void sayGoodBye() {
        System.out.println("GreetingService sayGoodBye!!!");
    }
}
