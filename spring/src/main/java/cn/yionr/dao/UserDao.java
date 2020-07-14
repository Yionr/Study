package cn.yionr.dao;

import cn.yionr.beans.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserDao {
    @Select("select * from student")
    public List<Student> getStudents();


    public void saveUser();
}
