package com.seoi.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shuaiqi
 * @create 2018-07-24 14:53
 * @desc 安全配置
 **/
@ConfigurationProperties(prefix = "my.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(final BrowserProperties browser) {
        this.browser = browser;
    }
}
