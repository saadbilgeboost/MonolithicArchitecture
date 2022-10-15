package com.saad.Java3Monolithic.controllermvc;

import com.saad.Java3Monolithic.mvcmodels.HomeModel;
import com.saad.Java3Monolithic.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeMvcController {
    private final ProductService productService;
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        HomeModel homeModel =HomeModel.builder()
                .menu(Arrays.asList("Home Page", "Products", "About Us", "Contact"))
                .title("Sales Management System")
                .avatar("https://www.w3schools.com/howto/img_avatar.png")
                .username("Saad")
                .products(productService.findAll()).build();
        modelAndView.addObject("model", homeModel);
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
