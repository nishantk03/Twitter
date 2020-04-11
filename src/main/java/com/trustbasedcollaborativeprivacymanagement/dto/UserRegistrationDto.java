package com.trustbasedcollaborativeprivacymanagement.dto;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "User_Registration")
public class UserRegistrationDto {
    @Id
    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

    @Column(name = "DOB")
    private String dateOfBirth;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Follower")
    private String follower;

    private Boolean isLoggedIn;

    @Column(name = "Pic")
    @Lob
    private String pic;
}
