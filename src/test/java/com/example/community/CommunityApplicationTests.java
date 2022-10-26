package com.example.community;

import com.example.community.dao.DiscussPostMapper;
import com.example.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void contextLoads() {
    }

    @Test
    public void testHtmlMail(){
        Context context=new Context();
        context.setVariable("username","spring-boot-starter-mail");

        String content=templateEngine.process("/mail/demo",context);
        System.out.println(content);
        mailClient.sendMail("xx","HTML",content);
    }

    @Test
    public void testTextMail(){
        mailClient.sendMail("xx","test","welcome");
    }


    @Test
    public void testString(){
        String fileName="hello.app";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }




}
