package com.aminenurgynk.service;

import com.aminenurgynk.dto.request.LoginRequestDto;
import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.dto.response.UserResponseDto;
import com.aminenurgynk.exception.ResourceNotFoundException;
import com.aminenurgynk.mapper.IUserMapper;
import com.aminenurgynk.repository.IUserRepository;
import com.aminenurgynk.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;



    public List<UserResponseDto> getAllUsers(){
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()){
            throw new RuntimeException("No data was found");
        }

        return IUserMapper.INSTANCE.toUserResponseDtos(userList);
    }

    public User getUserById(Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User could not found!!"));
        return userRepository.findById(id).get();
    }

    public User createUser(User user) { return userRepository.save(user);}

    public User updateUserById(User userInfo) throws ResourceNotFoundException {
        User user = userRepository.findById(userInfo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User could not found!!"));
        return userRepository.save(userInfo);
    }

    public String deleteUserById(Long id) throws ResourceNotFoundException{
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User could not found!!"));
        userRepository.deleteById(id);
        return "The user has been deleted from the database";
    }

    public UserResponseDto login(LoginRequestDto loginRequestDto) {
        Optional<User> user = userRepository.findByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (user.isEmpty()) throw  new RuntimeException("User could not found!!");

        return IUserMapper.INSTANCE.toUserResponseDto(user.get());
    }
}
