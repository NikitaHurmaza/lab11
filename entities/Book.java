package com.example.iab11.entities;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Data
@Named
@SessionScoped
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Book.SortAuthors", query = "select distinct b.author from Book b ORDER BY b.author ASC "),
        @NamedQuery(name = "Book.SortPublishers", query = "select distinct b.publisher from Book b"),
        @NamedQuery(name = "Book.SearchByPublisher", query = "select b from Book b where b.publisher like :searchByPublisher"),
        @NamedQuery(name = "Book.SearchByAuthor", query = "select b from Book b where b.author like :searchByAuthor "),
        @NamedQuery(name = "Book.SearchAfterYear", query = "select b from Book b where b.yearOfPublication > :yearOfPublication"),
})

public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "bookName", length = 50)
    private String bookName;

    @Size(max = 50)
    @Column(name = "author", length = 50)
    private String author;

    @Size(max = 50)
    @Column(name = "publisher", length = 50)
    private String publisher;

    @Column(name = "yearOfPublication")
    private Integer yearOfPublication;

    @Column(name = "price")
    private Double price;

    @Column(name = "numberOfPages")
    private Integer numberOfPages;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}