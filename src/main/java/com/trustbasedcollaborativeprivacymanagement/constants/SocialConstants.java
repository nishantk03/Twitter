package com.trustbasedcollaborativeprivacymanagement.constants;

public enum SocialConstants {
    USER_NOT_AVA( "Username already taken"),
    USER_CREATED( "User successfully created"),
    LOGIN_FAILED( "Check username and password"),
    TWEET_CREATED( "Tweet created"),
    TWEET_FAILED( "Tweet failed"),
    FOLLOWED( "Followed"),
    CANT_FOLLOWED( "Cannot follow yourself"),
    UNEXPECTED( "Unexpected error please check the connection");

    private final String key;

    SocialConstants(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
