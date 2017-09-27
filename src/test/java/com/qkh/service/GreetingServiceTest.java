package com.qkh.service;

import com.qkh.dao.GreetingDao;
import com.qkh.entity.MyBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class GreetingServiceTest {

    @Mock
    private GreetingDao dao;

    @InjectMocks
    private GreetingService greetingService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGreeting(){
        MyBean bean = new MyBean();
        bean.setFiledOne("filedOne");
        when(dao.greeting()).thenReturn(bean);
        assertNotNull(greetingService.greeting());
    }
}
