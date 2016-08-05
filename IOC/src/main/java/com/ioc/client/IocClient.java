package com.ioc.client;

import com.ioc.model.User;
import com.ioc.service.UserService;
import com.ioc.spring.BeanFactory;
import com.ioc.spring.ClassPathXmlApplicationContext;
import org.jdom.JDOMException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hengluwen on 16/8/5.
 */
public class IocClient {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, JDOMException, IOException {
        BeanFactory factory = new ClassPathXmlApplicationContext();

        UserService userService = (UserService)factory.getBean("userService");

        User user = (User)factory.getBean("user");
        user.setUserName("admin");
        user.setPassword("hengluwen");
        userService.addUser(user);

        System.out.println(user.toString());

    }
}
