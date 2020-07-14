package cn.yionr.service;

import cn.yionr.beans.Book;
import cn.yionr.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> getBooks(){
        return bookDao.getAll();
    }
}
