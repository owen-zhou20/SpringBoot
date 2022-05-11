package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        /*R r = new R();
        boolean flag = bookService.save(book);
        r.setFlag(flag);*/
        Boolean flag = bookService.save(book);
        if (book.getName().equals("123")) throw new IOException();
        return new R(flag, flag? "new record save success ^_^" : "false to save new record -_-!");
        //return new R(false);
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

/*    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            currentPage = (int) page.getPages();
            page = bookService.getPage(currentPage, pageSize);
        }
        return new R(true,page);
    }*/

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){


        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        //System.out.println("==========>"+book.getDescription());
        if(currentPage > page.getPages()){
            currentPage = (int) page.getPages();
            page = bookService.getPage(currentPage, pageSize, book);
        }
        return new R(true,page);
    }
}
