package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDao;
import web.model.User;


@Controller
@RequestMapping(value = "/")
public class UserController {


    @Autowired
    private UserDao userDaoImp;

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userDaoImp.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoImp.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userDaoImp.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaoImp.getUserById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("id") User user) {
        userDaoImp.updateUser(user);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String delitUserbyId(@PathVariable("id") int id){
        userDaoImp.deleteUserById(id);
        return "redirect:/";
    }

}
