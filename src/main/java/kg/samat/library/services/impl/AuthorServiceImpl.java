package kg.samat.library.services.impl;

import kg.samat.library.dao.AuthorRepository;
import kg.samat.library.entity.Authors;
import kg.samat.library.entity.dto.AuthorDto;
import kg.samat.library.exceptions.AuthorNotFoundException;
import kg.samat.library.services.AuthorService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.spi.LocaleServiceProvider;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;

    }

    @Override
    public Authors save(AuthorDto authorDto) {
        Authors authorsToSave = new Authors(authorDto);
        return authorRepository.save(authorsToSave);
    }

    @Override
    public List<Authors> getAll() {
        List<Authors> authorsList = authorRepository.findAll();
        return authorsList;
    }

    @Override
    public Authors update(AuthorDto authorDto) {
        Authors authorsFromDB = authorRepository.getById(authorDto.getId());
        authorsFromDB.setFirstName(authorDto.getFirstName());
        authorsFromDB.setLastName(authorDto.getLastName());
        return authorRepository.save(authorsFromDB);
    }

    @Override
    public void delete(Long id) throws AuthorNotFoundException {
        if(authorRepository.findById(id) != null){
            //Допилить обработчик
            authorRepository.deleteById(id);
        }
        else {
            throw new AuthorNotFoundException("Not found author with id: " + String.valueOf(id));

        }
    }


}
