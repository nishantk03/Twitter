package com.trustbasedcollaborativeprivacymanagement.controller;

import com.trustbasedcollaborativeprivacymanagement.constants.SocialConstants;
import com.trustbasedcollaborativeprivacymanagement.service.FriendsInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/network")
public class FriendCircle {

    @Autowired
    FriendsInfo friendsInfo;

    @ApiOperation(value = "Add follower")
    @GetMapping(value = "/addFollower", produces = "application/json")
    public String addFollower(@RequestParam String username,
                              @RequestParam String toFollow) {

        if (!toFollow.equals(username)) {
            friendsInfo.addFollower(toFollow, username);
            return SocialConstants.FOLLOWED.getKey() + " : " + toFollow;
        } else {
            return SocialConstants.CANT_FOLLOWED.getKey();
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
}
