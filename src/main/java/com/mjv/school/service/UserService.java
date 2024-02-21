package com.mjv.school.service;

import com.mjv.school.builder.UserMapper;
import com.mjv.school.dto.UserDTO;
import com.mjv.school.model.User;
import com.mjv.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserDTO> findById(Long id) {
        return Optional.ofNullable(userMapper.toDTO(userRepository.findById(id).get()));
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User userModel = userMapper.toEntity(userDTO);
        userModel = userRepository.save(userModel);

        return userMapper.toDTO(userModel);
    }

    public List<User> saveUserList(List<User> userList) {
        return userRepository.saveAll(userList);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User updateUser(User user) {
        Optional<User> userController = userRepository.findById(user.getId());
        return userRepository.save(userController.get());
    }

}
