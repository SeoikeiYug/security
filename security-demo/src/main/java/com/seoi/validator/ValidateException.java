package com.seoi.validator;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author shuaiqi
 * @create 2018-07-24 15:15
 * @desc validate exception
 **/
public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = 3285049418556112275L;

    private List<ObjectError> errors;

    public ValidateException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(final List<ObjectError> errors) {
        this.errors = errors;
    }
}
