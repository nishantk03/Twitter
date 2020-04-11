package com.trustbasedcollaborativeprivacymanagement.repository;

import com.trustbasedcollaborativeprivacymanagement.dto.UserRegistrationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationDtoRepository extends JpaRepository<UserRegistrationDto, String> {

    List<UserRegistrationDto> findByUserNameIn(List<String> username);
}
