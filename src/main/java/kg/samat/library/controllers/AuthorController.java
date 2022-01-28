package kg.samat.library.controllers;

import io.swagger.annotations.ApiOperation;
import kg.samat.library.entity.Authors;
import kg.samat.library.entity.dto.AuthorDto;
import kg.samat.library.exceptions.AuthorNotFoundException;
import kg.samat.library.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @ApiOperation(value = "Сохранение автора",consumes = "Сохранение автора")
    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public Authors saveAuthor(@RequestBody AuthorDto authorDto){
        return this.authorService.save(authorDto);
    }

    @GetMapping(value = "get_all")
    public ResponseEntity<List<Authors>> getAll(){
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Изменения автора", consumes = "Изменение автора")
    @PutMapping(value = "/edit",produces = MediaType.APPLICATION_JSON_VALUE)
    public Authors update(@RequestBody AuthorDto authorDto){
        return this.authorService.update(authorDto);
    }

    @ApiOperation(value = "удаление автора", consumes = "Удаление автора")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable(name = "id") Long id) throws AuthorNotFoundException {
        authorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
