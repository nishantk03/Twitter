package com.trustbasedcollaborativeprivacymanagement.repository;

import com.trustbasedcollaborativeprivacymanagement.dto.UserRegistrationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationDtoRepository extends JpaRepository<UserRegistrationDto, String> {
}
