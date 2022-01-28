package kg.samat.library.services;

import kg.samat.library.entity.Users;
import kg.samat.library.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    List<Users> getAll();

    boolean delete(Long id);

    //    Entity
    Users save(Users userEntity);

    Users update(Users userEntity);

    List<Users> getByLogin(Users userEntity);

    List<Users> getByRole(Users userEntity);

//    Dto
//    Users save(UserDto userDto);
//
//    Users update(UserDto userDto);
//
//    List<Users> getByLogin(UserDto userDto);
//
//    List<Users> getByRole(UserDto userDto);


}
