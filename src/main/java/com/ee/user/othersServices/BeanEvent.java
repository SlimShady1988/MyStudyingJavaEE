package com.ee.user.othersServices;

import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.inject.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "beanEvent", urlPatterns = "/beanEvent")
public class BeanEvent extends HttpServlet {
    @Inject
    BookService bookService;
    @Inject
    SubscriberBook subscriberBook;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookService.addBook(new Book("Tom Soer"));
        bookService.addBook(new Book("Tom Soer1"));
        bookService.addBook(new Book("Tom Soer2"));
        bookService.addBook(new Book("Tom Soer3"));
        resp.getWriter().println(""+subscriberBook.bookList.size());
        bookService.removeBook(subscriberBook.bookList.remove(1));
        resp.getWriter().println(""+subscriberBook.bookList.size());
    }
}
class Book {
    String name;
    public Book(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@interface add {}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@interface remove {}

class BookService {
    @Inject @add
    Event<Book> addEvent;
    @Inject @remove
    Event<Book> removeEvent;

    public void addBook(Book book) {
        System.out.println(book.getName() + " book was added");
        addEvent.fire(book);
    }

    public void removeBook(Book book) {
        System.out.println(book.getName() + " book was added");
        removeEvent.fire(book);
    }
}

@Singleton
class SubscriberBook {
    List<Book> bookList = new ArrayList<>();
    public void addBook (@Observes @add Book book) {
        System.out.println(book.getName() + " added to list");
        bookList.add(book);
    }
    public void removeBook (@Observes @remove Book book) {
        System.out.println(book.getName() + " removed from list");
        bookList.remove(book);
    }
}

