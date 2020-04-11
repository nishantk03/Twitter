package com.trustbasedcollaborativeprivacymanagement.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Profile_Pic")
public class ProfilePic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Pic")
    @Lob
    private byte[] pic;

    @Column(name= "username")
    private String username;

    @Column(name= "name")
    private String name;
}
