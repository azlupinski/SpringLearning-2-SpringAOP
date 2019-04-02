package pl.adamLupinski.springLearning.AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.adamLupinski.springLearning.AOP.model.Book;
import pl.adamLupinski.springLearning.AOP.service.BookRepository;
import pl.adamLupinski.springLearning.AOP.service.GenericRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopApp.class);

//        GenericRepository<String, Book> repository = context.getBean(GenericRepository.class);
        BookRepository repository = context.getBean(BookRepository.class);
        repository.add(new Book("1234567890123", "Inteligencja społeczna", "Daniel Goleman"));
        repository.add(new Book("3579086642135", "Tihnk in C++", "Bruce Eckel"));
        repository.add(new Book("4560981239875", "Lśnienie", "Stephen King"));
        repository.add(new Book("1234509876102", "Pani Jeziora", "Andrzej Sapkowski"));
        Book book = repository.get("3579086642135");
        System.out.println(book);

        context.close();

    }
}
