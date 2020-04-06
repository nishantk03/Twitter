package com.trustbasedcollaborativeprivacymanagement.controller;

import com.trustbasedcollaborativeprivacymanagement.constants.SocialConstants;
import com.trustbasedcollaborativeprivacymanagement.dto.ComposeTweet;
import com.trustbasedcollaborativeprivacymanagement.repository.ComposeTweetRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userfeatures")
public class UserFeatures {

    @Autowired
    ComposeTweetRepository composeTweetRepository;

    @ApiOperation(value = "Compose tweet", notes = "Compose tweet", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/composeTweet", produces = "application/json")
    public String composeTweet(@RequestBody ComposeTweet tweets) {
        if (tweets.getTweet() != null && tweets.getUsername() != null) {
            composeTweetRepository.save(tweets);
            return SocialConstants.TWEET_CREATED.getKey();
        } else {
            return SocialConstants.TWEET_FAILED.getKey();
        }
    }

    @ApiOperation(value = "Get all tweets")
    @GetMapping(value = "/getAllTweets", produces = "application/json")
    public List<ComposeTweet> getAllTweets() {

        return composeTweetRepository.findAll();
    }

    @ApiOperation(value = "Get my tweets")
    @GetMapping(value = "/getMyTweets", produces = "application/json")
    public List<ComposeTweet> getMyTweets(@RequestParam String username) {

        return composeTweetRepository.findByUsername(username);
    }



}
