package com.seoi.service.impl;

import com.seoi.service.IndexService;
import org.springframework.stereotype.Service;

/**
 * @author shuaiqi
 * @create 2018-07-24 16:25
 * @desc 初始service实现
 **/
@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public String greeting(final String username) {
        System.out.println("greeting method");
        return "hello," + username;
    }
}
