package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDao;



@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, @RequestParam(name = "count", required = false) Integer count) {
        model.addAttribute("cars", count == null ? CarDao.getSomeCars(Integer.MAX_VALUE) : CarDao.getSomeCars(count));
        return "cars";
    }
}
