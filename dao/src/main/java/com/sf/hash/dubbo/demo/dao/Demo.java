package com.sf.hash.dubbo.demo.dao;

import com.sf.hash.dubbo.demo.dao.mapper.UserMapper;
import com.sf.hash.dubbo.demo.dao.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Hash Zhang
 * @version 1.0.0
 * @date 2016/8/5
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:test.xml");
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = new User();
        user.setUsername("zhxhash");
        user.setPassword("zhxhash");
        System.out.println(new StringBuilder().append("插入前：").append(user.toString()).toString());
        userMapper.insert(user);
        System.out.println(new StringBuilder().append("插入后：").append(user.toString()).toString());
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        System.out.println(user1.toString());
        userMapper.deleteByPrimaryKey(user.getId());
    }
}
