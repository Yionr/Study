package cn.yionr.service;

import cn.yionr.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource(name="userDao")
    UserDao dao;

    public void changeUserName(){
        dao.getUser();
        dao.saveUser();
    }
}
