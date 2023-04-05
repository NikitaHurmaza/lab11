package com.example.iab11.beans;


import com.example.iab11.dao.BookDao;
import com.example.iab11.entities.Book;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
@Named
@SessionScoped
public class BookBean implements Serializable {
    @EJB
    private BookDao bookDao;
    private Book book = new Book();
    private String author;
    private String publisher;
    private int yearOfPublication;
    public List<Book> getBooks(){
        return bookDao.findAll();
    }
public List<Book> searchByAuthor(){
        return bookDao.searchByAuthor(author);
}
public List<Book> searchByPublisher(){
        return bookDao.searchByPublisher(publisher);
}
public List<Book> searchAfterYear(){
        return bookDao.searchAfterYear(yearOfPublication);
}
public List<Book> sortAuthors(){
        return bookDao.sortAuthors();
}
public List<Book> sortPublishers(){
        return bookDao.sortPublishers();
}
public HashMap<String, List<Book>> booksOfEachPublisher(){
        return bookDao.booksOfEachPublisher();
}
}
