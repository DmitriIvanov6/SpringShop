package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.sevices.UserService;
import ru.gb.validation.UserAlreadyExistAuthenticationException;
import ru.gb.validation.UserDto;

import javax.validation.Valid;

@Controller
@RequestMapping
public class RegController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String regPage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "/registration";
    }

    @PostMapping("/registration")
    public ModelAndView regUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("/registration");
        }
        try {
            userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistAuthenticationException uAEAE) {
            return new ModelAndView("/reg_error", "error_message", uAEAE.getMessage());
        }
        return new ModelAndView("/reg_success");
    }

    @GetMapping("reg_error")
    public String regErrorUser() {
        return "/reg_error";
    }

    @GetMapping("reg_success")
    public String regSuccess() {
        return "reg_success";
    }


}
