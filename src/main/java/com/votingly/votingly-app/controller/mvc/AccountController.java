package com.votingly.votingly-app.controller.mvc;

import com.votingly.votingly-app.controller.api.dto.user.UserDto;
import com.votingly.votingly-app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAccountPage() {
        return "account";
    }

    @GetMapping("{id}")
    public ModelAndView getOneUser(@PathVariable long id) {
        var oneUser = userService.getUserById(id);
        var mav = new ModelAndView();
        mav.setViewName("account");
        mav.addObject("one_user", new UserDto(
                oneUser.getId(),
                oneUser.getFirstName(),
                oneUser.getLastName(),
                oneUser.getEmail()
        ));
        return mav;
    }
}
