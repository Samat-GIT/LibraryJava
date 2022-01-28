package kg.samat.library.entity.dto;

import kg.samat.library.entity.Authors;
import lombok.Data;

@Data
public class AuthorDto {
    private Long id;

    private String firstName;

    private String lastName;

    public AuthorDto() {
    }

    public AuthorDto(Authors authorEntity){
        this.id = authorEntity.getId();
        this.firstName = authorEntity.getFirstName();
        this.lastName = authorEntity.getLastName();
    }

}
