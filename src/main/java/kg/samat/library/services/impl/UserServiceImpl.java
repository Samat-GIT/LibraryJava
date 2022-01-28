package kg.samat.library.services.impl;

import kg.samat.library.dao.UserRepository;
import kg.samat.library.entity.Users;
import kg.samat.library.entity.dto.UserDto;
import kg.samat.library.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAll() {
        List<Users> users= userRepository.findAll();
        return users;
    }

    @Override
    public boolean delete(Long id) {
        if(userRepository.findById(id)==null){
            //обработчик
            return false;
        }
        else {
            userRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public Users save(Users userEntity){
        return  userRepository.save(userEntity);
    }

    @Override
    public Users update(Users userEntity) {
        Users usersFromDB = userRepository.getById(userEntity.getId());
        usersFromDB.setLogin(userEntity.getLogin());//Если что скрыть
        usersFromDB.setPassword(userEntity.getPassword());
        usersFromDB.setRole(userEntity.getRole());
        return userRepository.save(usersFromDB);
    }

    @Override
    public List<Users> getByLogin(Users userEntity) {
       // Users usersFromDB = userRepository.getById();
        return null;
    }

    @Override
    public List<Users> getByRole(Users userEntity) {
        return null;
    }


}