package com.example.demo.Validator;

import com.example.demo.entity.User;
import com.example.demo.Validator.annotation.ValiUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
    public class ValiUserIdvalidator implements ConstraintValidator<ValiUserId,User> {
    @Override
    public boolean isValid(User user,ConstraintValidatorContext context){
        if(user == null)
            return true;
        return  user.getId()!=null;
    }
}
