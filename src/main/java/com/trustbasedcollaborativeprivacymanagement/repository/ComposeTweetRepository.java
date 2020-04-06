package com.trustbasedcollaborativeprivacymanagement.repository;

import com.trustbasedcollaborativeprivacymanagement.dto.ComposeTweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComposeTweetRepository extends JpaRepository<ComposeTweet, Integer> {
    List<ComposeTweet> findByUsername(String username);
}
