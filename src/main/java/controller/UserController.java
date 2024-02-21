package controller;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // FINDALLUSERS

    @GetMapping("find-by-id/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.fundById(id).get();
    }

    @PostMapping("save")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    // DELETEUSER

    // UPDATEUSER

}