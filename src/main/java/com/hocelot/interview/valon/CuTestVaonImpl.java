package com.hocelot.interview.valon;

import com.hocelot.interview.dto.InterviewTestRequest;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Slf4j
public class CuTestVaonImpl implements ConstraintValidator<CuTestVaon, InterviewTestRequest> {

    @Override
    public void initialize(CuTestVaon constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(InterviewTestRequest request, ConstraintValidatorContext context) {


        if(Objects.isNull(request.getPerData().getDocumentNumber())){
            setConstraintValidatorContext(context, "documentNumber must not be null");
            return false;
        }

        return true;
    }

    private void setConstraintValidatorContext(ConstraintValidatorContext context, String message){
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

}
