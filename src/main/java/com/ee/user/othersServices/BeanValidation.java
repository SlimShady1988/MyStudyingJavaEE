package com.ee.user.othersServices;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.io.IOException;
import java.util.Set;

@WebServlet("/beanValidation")
public class BeanValidation  extends HttpServlet {
    @Inject
    Person2 person;

    @Inject
    Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.age = 15;
        person.name = "Jora";
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//        Set<ConstraintViolation<Person2>> validate = validator.validate(person);
//        if (validate.size() > 0) {
//            System.out.println("some error");
//        }
//        for (ConstraintViolation<Person2> violation : validate) {
//            System.out.println(violation.getInvalidValue());
//            System.out.println(violation.getMessage());
//        }
        Set<ConstraintViolation<Person2>> email = validator.validateValue(Person2.class, "email", "myamail@gmail.com");
        Set<ConstraintViolation<Person2>> email1 = validator.validateValue(Person2.class, "email", "myamail@gmail.ru");

        for (ConstraintViolation<Person2> violation : email) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        for (ConstraintViolation<Person2> violation : email1) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }

    }
}
 class  Person2 {
     @Size(max = 25)
     String name;
     @Min(18)
     Integer age;
     @CheckEmail
     String email;
     @CheckEmail(mainName = "my")
     String email1;
     @CheckEmail(domain = "gmail")
     String email2;
     @CheckEmail(sufix = "com")
     String email3;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Integer getAge() {
         return age;
     }

     public void setAge(Integer age) {
         this.age = age;
     }
 }

//class EmailPattern implements ConstraintValidator<CheckEmail, String> {
//    String mainName;
//    String domain;
//    String sufix;
//
//    @Override
//    public void initialize(CheckEmail constraintAnnotation) {
//        mainName = constraintAnnotation.mainName();
//        domain =  constraintAnnotation.domain();
//        sufix =  constraintAnnotation.sufix();
//    }
//
//    @Override
//    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        if (s ==null || s.equals(""))
//            return true;
//        return false;
//    }
//
//}