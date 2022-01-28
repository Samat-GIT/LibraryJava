package kg.samat.library.entity.dto;

import kg.samat.library.entity.Genres;
import lombok.Builder;
import lombok.Data;

@Data

public class GenreDto {
    private Long id;

    private String name;

    public GenreDto(Genres genreEntity){
        this.id = genreEntity.getId();
        this.name = genreEntity.getGenre();
    }


}
