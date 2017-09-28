package com.qkh.service;

import com.qkh.dao.GreetingDao;
import com.qkh.entity.MyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements HellowService{

    Logger logger = LoggerFactory.getLogger(GreetingService.class);

    @Autowired
    private GreetingDao dao;

    public MyBean greeting()
    {
        return dao.greeting();
    }

    public void sayGoodBye() {
        logger.info("GreetingService sayGoodBye!!!");
    }
}
