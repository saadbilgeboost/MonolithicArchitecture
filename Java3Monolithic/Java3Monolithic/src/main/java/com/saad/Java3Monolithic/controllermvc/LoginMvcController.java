package com.saad.Java3Monolithic.controllermvc;

import com.saad.Java3Monolithic.repository.entity.Customer;
import com.saad.Java3Monolithic.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginMvcController {
    private final CustomerService customerService;
    @GetMapping("/loginpage")
    public ModelAndView loginPage(){
        String username = "Username";
        String password = "Password";
        ModelAndView modelAndView = new ModelAndView();
        /**
         * The name written inside setViewName should be same with the name of the html file.
         */
        modelAndView.setViewName("login");
        modelAndView.addObject("company", "BilgeAdam Java 3 Group ltd.");
        modelAndView.addObject("username",username);
        modelAndView.addObject("password", password);
        return modelAndView;
    }
    @PostMapping("/dologin")
    public ModelAndView doLogin(String txtusername, String txtpassword){
        if(customerService.isExistCustomer(txtusername,txtpassword)){
            return new ModelAndView("redirect:/home");
        }else{
            System.out.println("Wrong username or password.");
        }
        return null;
    }
    @GetMapping("/register")
    public ModelAndView register(){
        //"return new ModelAndView("register")" can also be used but you will not be able to use add object or other functions
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @GetMapping("/doregister")
    public ModelAndView doRegister (String email, String username, String password){
        customerService.save( Customer.builder()
                .email(email)
                .username(username)
                .password(password).build());
        return new ModelAndView("redirect:loginpage");
    }
}
