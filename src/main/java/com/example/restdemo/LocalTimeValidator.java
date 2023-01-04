package com.example.restdemo;

import com.example.restdemo.Aspect.AspectClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

public class LocalTimeValidator implements ConstraintValidator<DateFormatValid, String> {

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        if(Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", date)) {
            return true;
        }
        Logger log = LoggerFactory.getLogger(AspectClass.class);
        log.error("Wrong date format. Expected format: xx/xx/xxxx");
        return false;
    }
}
