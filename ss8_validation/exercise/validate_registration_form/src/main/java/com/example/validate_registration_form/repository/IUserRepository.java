package com.example.validate_registration_form.repository;

import com.example.validate_registration_form.dto.IUserDTO;
import com.example.validate_registration_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

//    @Query(value = "select u.fistName as fist_name,u.lastName as last_name,u.phoneNumber " +
//            "as phone_number,u.age as age ,u.email as email from User u")
//    List<IUserDTO> findAllUser();
}
