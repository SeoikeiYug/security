package com.seoi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author shuaiqi
 * @create 2018-07-23 15:26
 * @desc user details service 重写
 **/
public class UserDetailsServiceAdapt implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        logger.info("用户的用户名: {}", username);

        final String encode = passwordEncoder.encode("123456");
        logger.info("password: {}", encode);

        return new User(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }
}
