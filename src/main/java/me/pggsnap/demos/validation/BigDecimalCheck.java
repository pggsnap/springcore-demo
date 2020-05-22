package me.pggsnap.demos.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @author pggsnap
 * @date 2020/5/22
 */
public class BigDecimalCheck implements ConstraintValidator<BigDecimalValid, BigDecimal> {
    private BigDecimalValid standard;

    @Override
    public void initialize(BigDecimalValid constraintAnnotation) {
        this.standard = constraintAnnotation;
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        int precision = standard.precision();
        int scale = standard.scale();
        if (value != null && (value.scale() > scale || value.precision() > precision)) {
            context.disableDefaultConstraintViolation();    // 禁用默认提示信息，改成自定义信息
            context.buildConstraintViolationWithTemplate("precision > " + precision + " or scale > " + scale).addConstraintViolation();
            return false;
        }
        return true;
    }
}
