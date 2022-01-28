package kg.samat.library.entity.dto;

import kg.samat.library.entity.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;

    private String login;

    private String password;

    private RolesDto role;

    public UserDto() {
    }

    public UserDto(Long id, String login, String password, RolesDto rolesDto) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = rolesDto;
    }
}
