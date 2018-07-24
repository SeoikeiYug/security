package com.seoi.core.dto;

/**
 * @author shuaiqi
 * @create 2018-07-23 16:47
 * @desc 返回模型
 **/
public class BaseResponse {

    public BaseResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(final Object content) {
        this.content = content;
    }
}