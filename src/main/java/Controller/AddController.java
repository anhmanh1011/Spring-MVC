package Controller;

import Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import validator.PersonValidator;
import java.util.function.Consumer;

@Controller
public class AddController  {

    @Autowired
    ApplicationContext context;

    @GetMapping("/")
    public String add(){

            return "test";

    }
    @GetMapping("/vaditor")
    public String vaditor(@Validated Person person, BindingResult result){

        new PersonValidator().validate(person,result);
        if(result.hasErrors()){

             result.getAllErrors().forEach(new Consumer<ObjectError>() {
                 @Override
                 public void accept(ObjectError objectError) {
                     System.out.println(objectError.getCode());
                 }
             });
        }

        return person.getName() + " " + person.getAge();

    }
}
