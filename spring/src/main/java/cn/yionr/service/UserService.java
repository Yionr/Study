package cn.yionr.service;

import cn.yionr.beans.Book;
import cn.yionr.beans.Student;
import cn.yionr.dao.BookDao;
import cn.yionr.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<Student> getStudents(){
        return userDao.getStudents();
    }
}
