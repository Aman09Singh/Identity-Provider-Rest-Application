package com.restful.app.repository;

import com.restful.app.model.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserManagementRepository extends CrudRepository<UserDTO,Integer> {

    boolean deleteByUserEmail(String email);
    Optional<UserDTO> findByUserName(String userName);
}
