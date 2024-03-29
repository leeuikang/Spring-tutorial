package com.example.tutorial.app.reservation;

import org.apache.tomcat.util.bcel.Const;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndTimeMustBeAfterStartTimeValidaort implements
        ConstraintValidator<EndTimeMustBeAfterStartTime, ReservationForm> {
    private String message;

    @Override
    public void initialize(EndTimeMustBeAfterStartTime constraintAnnotation){
        message = constraintAnnotation.message();
    }
    @Override
    public boolean isValid(ReservationForm value, ConstraintValidatorContext context){
        if(value.getStartTime()==null || value.getEndTime() == null)
            return true;
        boolean isEndTimeMustBeAfterStartTime = value.getEndTime()
                .isAfter(value.getStartTime());
        if(!isEndTimeMustBeAfterStartTime){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("endTime").addConstraintViolation();
        }
        return isEndTimeMustBeAfterStartTime;
    }
}
