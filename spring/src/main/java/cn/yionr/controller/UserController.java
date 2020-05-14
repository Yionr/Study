package cn.yionr.controller;

import cn.yionr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService service;

    public void changeUserName(){
        service.changeUserName();
    }
}
