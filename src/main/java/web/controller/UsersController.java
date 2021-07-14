package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.UserServiceInterface;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServiceInterface userService;

    @Autowired
    public UsersController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping()
    public String index(Model model, Principal principal) {

        String email;

        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        } else {
            email = principal.getName();
        }

        model.addAttribute("user", userService.findByEmail(email));

        return "users/show";
    }

}
