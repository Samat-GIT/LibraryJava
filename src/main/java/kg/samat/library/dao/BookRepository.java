package kg.samat.library.dao;

import kg.samat.library.entity.Authors;
import kg.samat.library.entity.Books;
import kg.samat.library.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    Books findAllByUser(Long userId);

    List<Books> getByGenre(Genres genre);

    List<Books> getByAuthor(Authors author);

    Optional<Books> findById(Long bookId);
}
