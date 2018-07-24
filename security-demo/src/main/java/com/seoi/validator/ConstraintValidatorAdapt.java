package com.seoi.validator;

import com.seoi.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shuaiqi
 * @create 2018-07-24 16:32
 * @desc validate
 **/
public class ConstraintValidatorAdapt implements ConstraintValidator<ConstraintAdapt, Object> {

    @Autowired
    private IndexService indexService;

    @Override
    public void initialize(final ConstraintAdapt constraintAnnotation) {
        System.out.println("init constraint");
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        indexService.greeting("jenny");
        System.out.println(value);
        return false;
    }
}
