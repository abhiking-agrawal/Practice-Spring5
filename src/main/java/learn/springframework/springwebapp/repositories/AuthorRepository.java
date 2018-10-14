package learn.springframework.springwebapp.repositories;

import learn.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
