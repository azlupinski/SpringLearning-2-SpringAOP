package pl.adamlupinski.springlearning.aopwithspringboot.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.adamlupinski.springlearning.aopwithspringboot.model.Book;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BookRepository implements GenericRepository<String, Book>{

    private List<Book> books;
//    private static BookRepository instance = null;
//
//    public static BookRepository getInstance(){
//        if (instance == null){
//            instance = new BookRepository();
//        }
//        return instance;
//    }


    public BookRepository(){
        books = new LinkedList<>();
    }


    @Override
    public Book get(String isbn) {
        if (isbn == null || (isbn.length() != 13)) {
            throw new IllegalArgumentException("You write invalid ISBN number");
        }
        Book foundBook = books.stream()
                .filter(b -> isbn.equals(b.getIsbn()))
                .findFirst()
                .get();
        randomPause(300);
        return foundBook;
    }

    @Override
    public void add(Book book) {
        if ((book == null) || (book.getIsbn() == null) || (book.getTitle() == null) || (book.getAuthor() == null)){
            throw new IllegalArgumentException("Book have empty fields, you need to fill them all before you can add it");
        }
        randomPause(1000);
        books.add(book);

    }

    private void randomPause(int time){
        try{
            Thread.sleep(new Random().nextInt(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
