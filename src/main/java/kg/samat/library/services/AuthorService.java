package kg.samat.library.services;

import kg.samat.library.entity.Authors;
import kg.samat.library.entity.dto.AuthorDto;
import kg.samat.library.exceptions.AuthorNotFoundException;

import java.util.List;

public interface AuthorService {

    Authors save(AuthorDto authorDto);

    List<Authors> getAll ();

    Authors update(AuthorDto authorDto);

    void delete(Long id) throws AuthorNotFoundException;




}
