package kg.samat.library.controllers;


import io.swagger.annotations.ApiOperation;
import kg.samat.library.entity.Books;
import kg.samat.library.entity.dto.BookDto;
import kg.samat.library.services.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Сохранение книг", consumes = "Сохранение книг")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Books saveBook(@RequestBody BookDto bookDto){
        return bookService.save(bookDto);
    }

    @GetMapping(value = "/get_all")
    public List<Books> getAll(){
        return bookService.getAll();
    }


}
