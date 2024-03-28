package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDao;
import web.service.UserService;
import web.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", service.getAllUsers());
        return "users";
    }

    //create
    @GetMapping("/create_user")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create_user")
    public String getAddUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    //upd
    @GetMapping("/update_user")
    public String getUpdateUserForm(@RequestParam("id") long userId, Model model) {
        model.addAttribute("userUpdate", service.getUser(userId));
        return "update_user";
    }

    @PostMapping("/update_user")
    public String updateUserData(@ModelAttribute("userUpdate") User user) {
        service.updateUser(user.getId(), user);
        return "redirect:/";
    }


    //delete
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        service.deleteUser(id);
        return "redirect:/";
    }


}
