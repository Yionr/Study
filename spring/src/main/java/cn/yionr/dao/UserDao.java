package cn.yionr.dao;

import cn.yionr.beans.Student;
import cn.yionr.beans.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    @Select("select * from student")
    public List<Student> getStudents();


    public void saveUser();
}
