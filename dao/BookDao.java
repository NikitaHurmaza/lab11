package com.example.iab11.dao;


import com.example.iab11.entities.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


import java.util.*;

@Stateless
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();

    }

    public List<Book> searchByAuthor(String author) {
        TypedQuery<Book> query = em.createNamedQuery("Book.SearchByAuthor", Book.class);
        query.setParameter("searchByAuthor", author);
        List<Book> results = query.getResultList();
        return results;
    }

    public List<Book> searchByPublisher(String publisher) {
        TypedQuery<Book> query = em.createNamedQuery("Book.SearchByPublisher", Book.class);
        query.setParameter("searchByPublisher", publisher);
        List<Book> results = query.getResultList();
        return results;
    }

    public List<Book> searchAfterYear(int yearOfPublication) {
        TypedQuery<Book> query = em.createNamedQuery("Book.SearchAfterYear", Book.class);
        query.setParameter("yearOfPublication", yearOfPublication);
        List<Book> results = query.getResultList();
        return results;
    }
    public List<Book> sortAuthors(){
        return em.createNamedQuery("Book.SortAuthors", Book.class).getResultList();
    }
    public List<Book> sortPublishers(){
        return em.createNamedQuery("Book.SortPublishers", Book.class).getResultList();
    }
    public HashMap<String, List<Book>> booksOfEachPublisher() {
        TypedQuery<Book> query = em.createNamedQuery("Book.findAll", Book.class);
        List<Book> books = query.getResultList();
        HashMap<String, List<Book>> publisherMap = new HashMap<>();
        for (Book book : books) {
            if (!publisherMap.containsKey(book.getPublisher())) {
                publisherMap.put(book.getPublisher(), new ArrayList<>());
            }
            publisherMap.get(book.getPublisher()).add(book);
        }
        return publisherMap;
    }





}

