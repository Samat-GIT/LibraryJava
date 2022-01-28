package kg.samat.library.services;

import kg.samat.library.entity.Authors;
import kg.samat.library.entity.Books;
import kg.samat.library.entity.Genres;
import kg.samat.library.entity.dto.BookDto;

import java.util.List;

public interface BookService {

    Books save(BookDto bookDto);

    List<Books> getAll();

    Books update(BookDto bookDto);

    boolean delete(Long id);

    List<Books> getByGenre(Genres genre);

    List<Books> getByAuthor(Authors author);
}
