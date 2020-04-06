package com.trustbasedcollaborativeprivacymanagement.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Tweets")
public class ComposeTweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Tweet")
    private String tweet;

/*    @Column(name ="Image")
    private MultipartFile image;*/

    @Column(name= "username")
    private String username;

}
