package com.trustbasedcollaborativeprivacymanagement.service;

import com.trustbasedcollaborativeprivacymanagement.dto.UserRegistrationDto;
import com.trustbasedcollaborativeprivacymanagement.model.PicDto;
import com.trustbasedcollaborativeprivacymanagement.repository.ProfilePicRepository;
import com.trustbasedcollaborativeprivacymanagement.repository.UserRegistrationDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfilePicRepository profilePicRepository;

    @Autowired
    UserRegistrationDtoRepository userRegistrationDtoRepository;



 /*   public List<ProfilePic> uploadPic(MultipartFile file, String username) throws IOException {
        Optional<UserRegistrationDto> userName = userRegistrationDtoRepository.findById(username);
        ProfilePic profilePic = new ProfilePic();
        List<ProfilePic> profilePics = new ArrayList<>();
        if(userName.isPresent()){
            userName.get().setPic(file.getBytes());
            userRegistrationDtoRepository.save(userName.get());
            profilePic.setUsername(username);
            profilePic.setPic(file.getBytes());
            profilePic = profilePicRepository.save(profilePic);
            profilePics.add(profilePic);
        }

        return profilePics;
    }*/

    public List<UserRegistrationDto> uploadPic(PicDto picDto) {
        Optional<UserRegistrationDto> userName = userRegistrationDtoRepository.findById(picDto.getUsername());
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        List<UserRegistrationDto> dtos = new ArrayList<>();
        if (userName.isPresent()) {
            userName.get().setPic(picDto.getPic());
            registrationDto = userRegistrationDtoRepository.save(userName.get());
            dtos.add(registrationDto);
        }
        return dtos;
    }

}
