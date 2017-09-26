package com.qkh.config;

import com.qkh.entity.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication(scanBasePackages = "com.qkh")
public class App
{
    @RequestMapping("/greetings")
    public String greeting()
    {
        MyBean bean = new MyBean();
        bean.setFiledOne("hello Mr.Qiu！！！");
        return bean.getFiledOne();
    }
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
