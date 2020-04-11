package com.trustbasedcollaborativeprivacymanagement.repository;

import com.trustbasedcollaborativeprivacymanagement.dto.ProfilePic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePicRepository extends JpaRepository<ProfilePic, Integer> {
}
