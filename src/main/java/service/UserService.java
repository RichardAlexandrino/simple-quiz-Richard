package service;

import builder.UserMapper;
import dto.UserDTO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;


    public UserDTO saveUser(UserDTO userDTO) {
        User userModel = userMapper.toEntity(userDTO);
        userModel = userRepository.save(userModel);

        return userMapper.toDTO(userModel);
    }

    public List<User> saveUserList(List<User> userList) {
        return userRepository.saveAll(userList);
    }

    public Optional<UserDTO> fundById(Long id) {
        return Optional.ofNullable(userMapper.toDTO(userRepository.findById(id).get()));
    }

    public User updateUser(User user) {
        Optional<User> userController = userRepository.findById(user.getId());
        return userRepository.save(userController.get());
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}