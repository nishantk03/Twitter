package com.trustbasedcollaborativeprivacymanagement.service;

import com.trustbasedcollaborativeprivacymanagement.dto.UserRegistrationDto;
import com.trustbasedcollaborativeprivacymanagement.repository.UserRegistrationDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FriendsInfo {

    @Autowired
    UserRegistrationDtoRepository userRegistrationDtoRepository;

    public Set<String> getFollowers(String username) {
        Optional<UserRegistrationDto> dto = userRegistrationDtoRepository.findById(username);
        Set<String> followerList;
        if (dto.isPresent()) {
            followerList = new HashSet<>(Arrays.asList(dto.get().getFollower().split(",")));
            followerList.remove("string");
            followerList.remove("null");
            return followerList;
        }
        followerList = new HashSet<>();
        return followerList;

    }

    public List getFollowing(String username) {
        List<UserRegistrationDto> dto = userRegistrationDtoRepository.findAll();

        return dto.stream().filter(data -> data.getFollower().contains(username)).collect(Collectors.toList());
    }

    @Transactional
    public void addFollower(String toFollow, String username) {
        Optional<UserRegistrationDto> dto = userRegistrationDtoRepository.findById(username);
        if (dto.isPresent()) {
            String follower = dto.get().getFollower();
            follower += "," + toFollow;
            dto.get().setFollower(follower);
            userRegistrationDtoRepository.save(dto.get());
        }
    }

}
