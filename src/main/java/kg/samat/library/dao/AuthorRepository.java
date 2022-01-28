package kg.samat.library.dao;

import kg.samat.library.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
    Optional<Authors>  findById(Long authorId);


}
