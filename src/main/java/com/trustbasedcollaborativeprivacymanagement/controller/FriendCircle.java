package com.trustbasedcollaborativeprivacymanagement.controller;

import com.trustbasedcollaborativeprivacymanagement.constants.SocialConstants;
import com.trustbasedcollaborativeprivacymanagement.dto.UserRegistrationDto;
import com.trustbasedcollaborativeprivacymanagement.model.PicDto;
import com.trustbasedcollaborativeprivacymanagement.service.FriendsInfo;
import com.trustbasedcollaborativeprivacymanagement.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/network")
@CrossOrigin
public class FriendCircle {

    @Autowired
    FriendsInfo friendsInfo;

    @Autowired
    ProfileService profileService;

    @ApiOperation(value = "Add follower")
    @GetMapping(value = "/addFollower", produces = "application/json")
    public List<String> addFollower(@RequestParam String username,
                                    @RequestParam String toFollow) {
        List<String> list = new ArrayList<>();
        if (!toFollow.equals(username)) {
            friendsInfo.addFollower(toFollow, username);
            list.add(SocialConstants.FOLLOWED.getKey() + " : " + toFollow);
            return list;
        } else {
            list.add(SocialConstants.CANT_FOLLOWED.getKey());
            return list;
        }
    }

    @ApiOperation(value = "Get follower")
    @GetMapping(value = "/getFollower", produces = "application/json")
    public Set<String> getFollower(@RequestParam String username) {

        return friendsInfo.getFollowers(username);
    }

    @ApiOperation(value = "Get following")
    @GetMapping(value = "/getFollowing", produces = "application/json")
    public List getFollowing(@RequestParam String username) {

        return friendsInfo.getFollowing(username);
    }

    @ApiOperation(value = "Get all users")
    @GetMapping(value = "/getAllUsers", produces = "application/json")
    public List getAllUsers() {

        return friendsInfo.getAllUsers();
    }

    /*@PostMapping("/uploadFile")
    public List<ProfilePic> uploadFile(@RequestParam("imageToUpload") MultipartFile file,
                                       @RequestParam String usernames) throws IOException {

        return profileService.uploadPic(file, usernames);
    }
    */
    @PostMapping("/uploadFile")
    public List<UserRegistrationDto> uploadFile(@RequestBody PicDto file) {
        return profileService.uploadPic(file);
    }

}
