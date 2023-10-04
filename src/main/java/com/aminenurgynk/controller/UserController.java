package com.aminenurgynk.controller;


import com.aminenurgynk.dto.request.LoginRequestDto;
import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.dto.response.UserResponseDto;
import com.aminenurgynk.exception.ResourceNotFoundException;
import com.aminenurgynk.repository.entity.User;
import com.aminenurgynk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.aminenurgynk.constant.RestApiUrl.*;

import java.util.List;

//GET http://localhost:8080/user
@RestController
@RequestMapping(USER)
public class UserController {

    @Autowired
    UserService userService;



    //GET http://localhost:8080/user/getAllUsers
    @GetMapping(GETALLUSERS)
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //GET http://localhost:8080/user/getUserById/2
    @GetMapping(GETUSER_BYID)
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    //POST http://localhost:8080/user/createUser
    @PostMapping(CREATEUSER)
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    //PUT http://localhost:8080/user/updateUserById/2
    @PutMapping(UPDATEUSER_BYID)
    public ResponseEntity<User> updateUserById(@PathVariable(value = "id") Long id, @RequestBody User user) throws ResourceNotFoundException {

        User userInfo = getUserById(id).getBody();
        if (userInfo != null){
            userInfo.setId(id);
            userInfo.setFirstName(user.getFirstName());
            userInfo.setLastName(user.getLastName());
            userInfo.setEmail(user.getEmail());
            userInfo.setPassword(user.getPassword());
            return ResponseEntity.ok(userService.updateUserById(userInfo));
        }
        return null;
    }

    //DELETE http://localhost:8080/user/deleteUserById/2
    @DeleteMapping(DELETEUSER_BYID)
    public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(userService.deleteUserById(id));
    }


    @PostMapping(LOGIN)
    public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }








}
