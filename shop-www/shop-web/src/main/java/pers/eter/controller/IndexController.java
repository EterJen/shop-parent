package pers.eter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.eter.core.base.BaseController;

/**
 * Created by Eter on 17-6-6.
 */
@Controller
public class IndexController extends BaseController{
    @RequestMapping("index")
    public String index(Model model) {
        return "index";
    }
}
