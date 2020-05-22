package me.pggsnap.demos.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

/**
 * @author pggsnap
 * @date 2020/5/4
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name should not empty");
        ValidationUtils.rejectIfEmpty(errors, "birth", "birth should not empty");
        Person p = (Person) target;
        if (p.getBirth().compareTo(LocalDate.of(1920, 1, 1)) < 0) {
            errors.rejectValue("birth", "too old");
        }
    }
}
