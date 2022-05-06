package com.itheima.dao;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        //book.setId(5);
        book.setName("C++");
        book.setType("IT");
        book.setDescription("123");

        System.out.println(bookDao.insert(book));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(8);
        book.setName("VB");
        book.setType("IT");
        book.setDescription("456");
        System.out.println(bookDao.updateById(book));
    }

    @Test
    void testDelete(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testGetPage(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testGetBy(){
        System.out.println(bookDao.selectById(1));
    }


}
