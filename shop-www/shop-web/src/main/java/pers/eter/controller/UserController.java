package pers.eter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.eter.core.model.User;
import pers.eter.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Eter on 17-6-5.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
/*    @ResponseBody
    @RequestMapping("index")
    public String index() {
        return "hell";
    }

    @RequestMapping("index2")
    @ResponseBody
    public Map<String, Object> index2() {
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", 200);
        result.put("resultMessage", "Success");
        return result;
    }*/

    @PutMapping("add")
    public Map<String, Object> add(User user) {
        Integer userId = userService.add(user);
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", 200);
        result.put("resultMessage", "Success");
        result.put("userId", userId);

        return result;

    }

    @RequestMapping("find")
    public Map<String, Object> find(String uname) {
        List<User> users = userService.find(uname);
        Map<String, Object> result = new HashMap<>();

        result.put("resultCode", 200);
        result.put("resultMessage", "Success");
        result.put("users", users);

        return result;
    }
}
