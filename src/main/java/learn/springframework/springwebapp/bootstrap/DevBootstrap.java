package learn.springframework.springwebapp.bootstrap;

import learn.springframework.springwebapp.model.Author;
import learn.springframework.springwebapp.model.Book;
import learn.springframework.springwebapp.model.Publisher;
import learn.springframework.springwebapp.repositories.AuthorRepository;
import learn.springframework.springwebapp.repositories.BookRepository;
import learn.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher rodPub = new Publisher();
        rodPub.setName("Xqq");
        rodPub.setAddress("12121");
        publisherRepository.save(rodPub);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234",rodPub);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444",rodPub);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
