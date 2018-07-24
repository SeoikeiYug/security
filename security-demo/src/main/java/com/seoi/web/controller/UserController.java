package com.seoi.web.controller;

import com.seoi.dto.User;
import com.seoi.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaiqi
 * @create 2018-07-24 15:27
 * @desc 用户controller
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, @PathVariable("id") String id, BindingResult result) {
        System.out.println(id);
        System.out.println(user);
        user.setUserName("update name");
        return user;
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<User> getUsers(UserQueryCondition userQueryCondition, @PageableDefault(page = 1, size = 20, sort = "username,asc") Pageable pageable) {
        // 反射工具，打印对象的属性，值
        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));

        List<User> users = new ArrayList<>();
        users.add(new User("Hehe", "123456"));
        users.add(new User("Tom", "654321"));
        users.add(new User("Rose", "142536"));
        return users;
    }

    // 正则表达式
    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable String id) {
        User user = new User();
        user.setUserName("tom");
        return user;
    }

}
