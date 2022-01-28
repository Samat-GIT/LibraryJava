package kg.samat.library.entity.dto;

import kg.samat.library.entity.Roles;
import lombok.Builder;
import lombok.Data;

@Data

public class RolesDto {

    private Long id;

    private String name;

    public RolesDto(Roles rolesEntity){
        this.id = rolesEntity.getId();
        this.name=rolesEntity.getRoleName();
    }
}
