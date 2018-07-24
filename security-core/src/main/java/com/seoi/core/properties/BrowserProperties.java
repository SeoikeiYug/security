package com.seoi.core.properties;

/**
 * @author shuaiqi
 * @create 2018-07-24 14:43
 * @desc browser properties
 **/
public class BrowserProperties {

    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(final String loginPage) {
        this.loginPage = loginPage;
    }
}
