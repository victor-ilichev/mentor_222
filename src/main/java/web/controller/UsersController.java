package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoInterface;
import web.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDaoInterface userDao;

    @Autowired
    public UsersController(UserDaoInterface userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.listUsers());

        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDao.find(id));

        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @GetMapping("/{id}/not-exists")
    public String notExists(@PathVariable("id") long id, Model model) {
        model.addAttribute("id", id);

        return "users/not-exists";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userDao.save(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        User user = userDao.find(id);


        if (null == user) {
            return "redirect:/users/" + id + "/not-exists";
        }

        model.addAttribute("user", user);

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") long id) {

        if (null == user) {
            return "redirect:/users/" + id + "/not-exists";
        }

        if (bindingResult.hasErrors()) {
            return "users/edit";
        }

        userDao.update(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userDao.delete(user);

        return "redirect:/users";
    }
}
