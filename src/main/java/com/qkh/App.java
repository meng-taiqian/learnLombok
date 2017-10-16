package com.qkh;

import com.qkh.entity.MyBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication(scanBasePackages = "com.qkh")
@MapperScan("com.qkh.mapper")
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
