package com.foo.springsecurity.controller;

import com.foo.springsecurity.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author foo
 * @since 2022-05-30
 */
@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final ProductService productService;

    @GetMapping("/main")
    public String main(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        model.addAttribute("products", productService.findAll());
        return "main.html";
    }

}
