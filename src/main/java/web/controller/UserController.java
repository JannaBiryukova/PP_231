package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<User> users = service.getAllUsers();
        model.addAttribute("allUsers", users);
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
    public String getUpdateUserForm(Model model) {
        model.addAttribute("userUpdate", new User());
        return "update_user";
    }

    @PostMapping("/update_user")
    public String getUpdateUser(@ModelAttribute("userUpdate") User user) {
        try {
            service.updateUser(user.getId(), user);
        } catch (Exception e) {
            System.out.println("No this user!");
        }
        return "redirect:/";
    }

    //delete

    //
    @GetMapping("/delete_user")
    public String getDeleteUserForm(Model model) {
        model.addAttribute("userDelete", new User());
        return "delete_user";
    }

    @PostMapping("/delete_user")
    public String getDeleteUser(@ModelAttribute("userDelete") User user) {
        try {
            service.deleteUser(user.getId());
        } catch (Exception e) {
            System.out.println("Error");
        }

        return "redirect:/";
    }

}
