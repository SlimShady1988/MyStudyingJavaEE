package com.ee.user.othersServices;

//import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "ejb", urlPatterns = "/ejbValidators")
public class EnterpriseMultiThreads extends HttpServlet {
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executorService;
    @Inject
    Validator validator;
    @Inject
    Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ManagedExecutorService - Multithreads
        executorService.submit(() -> {System.out.println("new Runnable executed");});
        try {
            System.out.println(executorService.submit(() -> "Callable called").get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

                                            // Inject Groups(selected fields, not all)
//        Set<ConstraintViolation<Person>> name = validator.validate(person, MyGroup3.class);
//        person.s1 = "1";
//        person.s2 = "2";
//        person.s3 = "3";
//        person.s4 = "4";
//        for (ConstraintViolation<Person> violation : name) {
//            System.out.println(violation.getMessage() + " getMessage");
//            System.out.println(violation.getInvalidValue()+ " getinvalidValue");
//        }

                                            // Annotation Validation
                                            // Get validator from Interface(without Injecting)
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.getValidator();
//        /*Some Code*/
//        validatorFactory.close();
        person.name = "vic";
        person.age = 15;
        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        if (validate.size() > 0) {
            System.out.println("Some Wrong by Validation");
            System.out.println(validate.size());
        }
        for (ConstraintViolation<Person> violation : validate) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }

    }
}
interface MyGroup1 {}
interface MyGroup2 {}
interface MyGroup3 {}
interface MyGroup4 {}

class Person {
    // Inject Groups(selected fields, not all)
//    @NotNull(groups = MyGroup1.class)
//    String s1;
//    @NotNull(groups = {MyGroup1.class, MyGroup2.class, Default.class})
//    String s2;
//    @NotNull(groups = MyGroup3.class)
//    String s3;
//    @NotNull(groups = Default.class)
//    String s4;
    @Pattern(regexp = "[A-Z] [a-z]*")
    String name;
    @Min(18)
    int age;
}