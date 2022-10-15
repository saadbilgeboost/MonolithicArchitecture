package com.saad.Java3Monolithic.controllermvc;

import com.saad.Java3Monolithic.dto.request.ProductSaveRequestDto;

import com.saad.Java3Monolithic.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductMvcController {
    private final ProductService productService;
    // http://localhost:9090/product/save
    @PostMapping("/save")
    public ModelAndView save(ProductSaveRequestDto dto){
        productService.save(dto);
        return new ModelAndView("redirect:/home");
    }
}
