package com.trustbasedcollaborativeprivacymanagement.controller;

import com.trustbasedcollaborativeprivacymanagement.constants.SocialConstants;
import com.trustbasedcollaborativeprivacymanagement.dto.ComposeTweet;
import com.trustbasedcollaborativeprivacymanagement.repository.ComposeTweetRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userfeatures")
@CrossOrigin
public class UserFeatures {

    @Autowired
    ComposeTweetRepository composeTweetRepository;

    @ApiOperation(value = "Compose tweet", notes = "Compose tweet", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/composeTweet", produces = "application/json")
    public List<String> composeTweet(@RequestBody ComposeTweet tweets) {
        List<String> list = new ArrayList<>();
        if (tweets.getTweet() != null && tweets.getUsername() != null) {
            composeTweetRepository.save(tweets);
            list.add(SocialConstants.TWEET_CREATED.getKey());
            return list;
        } else {
            list.add(SocialConstants.TWEET_FAILED.getKey());
            return list;
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

    @ApiOperation(value = "Delete tweets")
    @GetMapping(value = "/deleteTweets", produces = "application/json")
    public List<String> deleteTweets(@RequestParam Integer id) {
        Optional<ComposeTweet> composeTweet = composeTweetRepository.findById(id);
        composeTweetRepository.delete(composeTweet.get());
        List<String> list = new ArrayList<>();
        list.add("Tweet deleted");
        return list;
    }


}
