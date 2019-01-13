package validator;

import Model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {


        Person p = (Person)o;
        System.out.println(p);
        if(p.getName().equals("")){
            errors.reject("ten loi");
        }
        if(p.getAge()<0){

            errors.reject("age","tuoi < 0");
        }else if (p.getAge() > 110){
            errors.reject("tuoi  > 110");


        }
    }
}
