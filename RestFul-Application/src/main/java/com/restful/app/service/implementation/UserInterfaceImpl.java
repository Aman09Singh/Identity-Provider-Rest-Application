package com.restful.app.service.implementation;

import com.restful.app.model.UserDTO;
import com.restful.app.repository.UserManagementRepository;
import com.restful.app.service.UserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserInterfaceImpl implements UserInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserInterfaceImpl.class);

    private final UserManagementRepository userManagementRepository;

    public UserInterfaceImpl(UserManagementRepository userManagementRepository) {
        this.userManagementRepository = userManagementRepository;
    }

    @Override
    public boolean deleteUser(String email) {
        return userManagementRepository.deleteByUserEmail(email);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO){
        return userManagementRepository.save(userDTO);
    }
}
