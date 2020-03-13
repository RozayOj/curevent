package com.curevent.utils;

import com.curevent.models.User;
import com.curevent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (userService.getOneByEmail(user.getEmail()) != null) {
            errors.rejectValue(
                    "email", "", "This email is already in use"
            );
        }
        if (userService.getOneByUsername(user.getUsername()) != null) {
            errors.rejectValue(
                    "username", "", "This username is already in use"
            );
        }
    }
}