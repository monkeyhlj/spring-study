package com.monkeyhlj.controller;

import com.monkeyhlj.entity.User;
import com.monkeyhlj.repository.UserTest;
import com.monkeyhlj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserTest userTest;

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",userService.findAll());
        return modelAndView;
    }

    @GetMapping("/map")
    public String map(Map<String,User> map){
        User user = userTest.findById(1);
        map.put("user",user);
        return "view";
    }

    @GetMapping("/map2")
    public String map2(Map<String,User> map){
        User user = new User();
        user.setId(1);
        user.setRoleName("张三");
        user.setRoleDsc("管理员");
        map.put("user",user);
        return "view";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(){
        return "modelAndView";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
