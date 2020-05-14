package cn.yionr.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void getUser(){
        System.out.println("正在获取用户");
    }

    public void saveUser() {
        System.out.println("正在保存用户");
    }
}
