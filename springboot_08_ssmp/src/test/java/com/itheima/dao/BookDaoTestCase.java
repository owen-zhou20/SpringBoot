package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        System.out.println(bookDao.deleteById(9));
    }

    @Test
    void testGetAll(){

        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage(){
        IPage page = new Page(2,5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","C++");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "c++";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //if(name!=null) lqw.like(Book::getName,name);
        lqw.like(name != null,Book::getName,name);
        bookDao.selectList(lqw);
    }


}
