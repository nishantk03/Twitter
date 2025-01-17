package com.trustbasedcollaborativeprivacymanagement.controller;

import com.trustbasedcollaborativeprivacymanagement.constants.SocialConstants;
import com.trustbasedcollaborativeprivacymanagement.dto.UserRegistrationDto;
import com.trustbasedcollaborativeprivacymanagement.model.UserDetails;
import com.trustbasedcollaborativeprivacymanagement.repository.UserRegistrationDtoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserRegistrationDtoRepository userRegistrationDtoRepository;

    @ApiOperation(value = "User registration", notes = "Register new user", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/registerUser", produces = "application/json")
    public List<String> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        Optional<UserRegistrationDto> userName = userRegistrationDtoRepository.findById(registrationDto.getUserName());
        List<String> list = new ArrayList<>();
        if (!userName.isPresent()) {
            UserRegistrationDto dto = userRegistrationDtoRepository.save(registrationDto);
            list.add(SocialConstants.USER_CREATED.getKey());
            return list;
        } else {
            list.add(SocialConstants.USER_NOT_AVA.getKey());
            return list;
        }
    }

    @ApiOperation(value = "User login", notes = "User login", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/login")
    public List<UserRegistrationDto> getUserDetails(@RequestParam String username,
                                                    @RequestParam String password) {

        Optional<UserRegistrationDto> userDetails = userRegistrationDtoRepository.findById(username);
        if (userDetails.isPresent() && userDetails.get().getPassword().toString().equals(password)) {
            List<UserRegistrationDto> userList = new ArrayList<>();
            userDetails.get().setIsLoggedIn(true);
            userList.add(userDetails.get());
            return userList;
        } else {
            List<UserRegistrationDto> loggedInFailed = new ArrayList<>();
            UserRegistrationDto userInfo = new UserRegistrationDto();
            userInfo.setIsLoggedIn(false);
            loggedInFailed.add(userInfo);
            return loggedInFailed;
        }
    }

    public List<UserDetails> getAllUsers() {
        List<UserRegistrationDto> registrationDtos = userRegistrationDtoRepository.findAll();
        List<UserDetails> userDetails = new ArrayList<>();

        registrationDtos.stream().forEach(data -> {
            UserDetails userDetails1 = new UserDetails();
            userDetails1.setFirstName(data.getFirstName());
            userDetails1.setLastName(data.getLastName());
            userDetails1.setUsername(data.getUserName());
            userDetails.add(userDetails1);
        });
        return userDetails;
    }

    @ApiOperation(value = "Get selected users", notes = "Get selected users", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/getSelectedUsers")
    public List<UserRegistrationDto> getUsers(@RequestBody List<String> userName) {
        List<UserRegistrationDto> registrationDtos = userRegistrationDtoRepository.findByUserNameIn(userName);

        return registrationDtos;
    }

}
