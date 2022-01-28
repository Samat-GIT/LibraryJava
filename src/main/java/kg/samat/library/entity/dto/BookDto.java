package kg.samat.library.entity.dto;

import kg.samat.library.entity.Books;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

@NoArgsConstructor
public class BookDto {

    private Long id;

    private String name;

    private LocalDateTime addDate;

    private Long authorId;

    private Long userId;

    private Long genreId;

    public BookDto(Books bookEntity /* , AuthorDto authorDto, UserDto userDto, GenreDto genreDto*/){
        this.id = bookEntity.getId();
        this.name = bookEntity.getName();
        this.addDate = bookEntity.getAddDate();

        this.authorId = bookEntity.getAuthor().getId();
        this.userId = bookEntity.getUser().getId();
        this.genreId = bookEntity.getGenre().getId();



    }

}
