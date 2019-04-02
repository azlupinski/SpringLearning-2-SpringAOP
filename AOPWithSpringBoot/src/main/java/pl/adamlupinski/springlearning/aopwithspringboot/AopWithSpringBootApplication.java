package pl.adamlupinski.springlearning.aopwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.adamlupinski.springlearning.aopwithspringboot.model.Book;
import pl.adamlupinski.springlearning.aopwithspringboot.service.BookRepository;
import pl.adamlupinski.springlearning.aopwithspringboot.service.GenericRepository;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopWithSpringBootApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(AopWithSpringBootApplication.class, args);

        GenericRepository<String, Book> repository = context.getBean(GenericRepository.class);
        repository.add(new Book("1234567890123", "Inteligencja społeczna", "Daniel Goleman"));
        repository.add(new Book("3579086642135", "Tihnk in C++", "Bruce Eckel"));
        repository.add(new Book("4560981239875", "Lśnienie", "Stephen King"));
        repository.add(new Book("1234509876102", "Pani Jeziora", "Andrzej Sapkowski"));
        Book book = repository.get("3579086642135");
        System.out.println(book);


        BookRepository repo = context.getBean(BookRepository.class);
        repo.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
        repo.add(new Book("2345678901234", "Druga", "Drugi autor"));
        repo.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
        // repo.add(null);
        Book book2 = repo.get("1234567890123"); // found
        System.out.println(book2);

        context.close();

}

}
