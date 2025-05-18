package com.restful.app.service;

import com.restful.app.model.UserDTO;

public interface UserInterface {
    
    public boolean deleteUser(String email);
    public UserDTO saveUser(UserDTO userDTO);
}
