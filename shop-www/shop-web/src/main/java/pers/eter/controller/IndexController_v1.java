package pers.eter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Eter on 17-6-6.
 */
@Controller
@RequestMapping("index")
public class IndexController_v1 {
    @RequestMapping("{age}")
    /*路径变量声明与使用*/
    public String index(@PathVariable Integer age, Model model) {
        /*手动加入作用域*/
        model.addAttribute("age", age);
        return "index";

    }
}
