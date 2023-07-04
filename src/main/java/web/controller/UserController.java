package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import web.DAO.UserDao;


@Controller
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserDao userDaoImp;

    @GetMapping()
    public String getAllUsers(Model model) {
    model.addAttribute("users", userDaoImp.getAllUsers());
        return "users/index";
    }

    @GetMapping("{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoImp.getUserById(id));
        return "users/show";
    }
}
