package kg.samat.library.services.impl;

import kg.samat.library.dao.AuthorRepository;
import kg.samat.library.dao.BookRepository;
import kg.samat.library.dao.GenreRepository;
import kg.samat.library.dao.UserRepository;
import kg.samat.library.entity.Authors;
import kg.samat.library.entity.Books;
import kg.samat.library.entity.Genres;
import kg.samat.library.entity.Users;
import kg.samat.library.entity.dto.BookDto;
import kg.samat.library.services.BookService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private GenreRepository genreRepository;
    private AuthorRepository authorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository, UserRepository userRepository){
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Books save(BookDto bookDto) {
        Books bookToSave = new Books(bookDto);
        Authors authorFromDb = authorRepository.getById(bookDto.getAuthorId());
        bookToSave.setAuthor(authorFromDb);
        Genres genreFromDb = genreRepository.getById(bookDto.getGenreId());
        bookToSave.setGenre(genreFromDb);
        Users userFromDb = userRepository.getById(bookDto.getUserId());
        bookToSave.setUser(userFromDb);
        return bookRepository.save(bookToSave);
    }

    @Override
    public List<Books> getAll() {
        List<Books> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Books update(BookDto bookDto) {
        Users user = userRepository.getById(bookDto.getUserId());
        Authors author = authorRepository.getById(bookDto.getAuthorId());
        Genres genre = genreRepository.getById(bookDto.getGenreId());

        Books bookFromDB = bookRepository.getById(bookDto.getId());
        bookFromDB.setName(bookDto.getName());
        bookFromDB.setAuthor(author);
        bookFromDB.setUser(user);
        bookFromDB.setGenre(genre);

        //save(bookFromDB);
        return bookRepository.save(bookFromDB);
    }

    @Override
    public boolean delete(Long id){
        if(bookRepository.findById(id) == null){
           //Сделать обработчик
            return false;
        }
        else {
            bookRepository.deleteById(id);
            return  true;
        }
    }

    @Override
    public List<Books> getByGenre(Genres genre) {
        Genres genres = genreRepository.getById(genre.getId());
        List<Books> booksFromDB = bookRepository.getByGenre(genres);
        return booksFromDB;
    }

    @Override
    public List<Books> getByAuthor(Authors author) {
        Authors authors = authorRepository.getById(author.getId());
        List<Books> booksFromDB = bookRepository.getByAuthor(authors);
        return booksFromDB;
    }
//
//    @Override
//    public Books search(BookDto ) {
//        return null;
//    }



}

