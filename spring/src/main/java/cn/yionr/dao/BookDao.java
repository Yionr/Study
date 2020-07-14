package cn.yionr.dao;

import cn.yionr.beans.Book;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    @Update("update account set balance = balbance - #{price} where username = #{userName}")
    public void updateBalance(String userName,int price);

    @Select("select * from book")
    public List<Book> getAll();
}
