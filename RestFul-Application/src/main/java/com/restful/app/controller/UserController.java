package com.restful.app.controller;

import com.restful.app.model.UserDTO;
import com.restful.app.service.implementation.UserInterfaceImpl;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserInterfaceImpl userInterface;

    public UserController(UserInterfaceImpl userInterface) {
        this.userInterface = userInterface;
    }

    @DeleteMapping("/user/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email){
        logger.info("Inside delete User method with email id :: {}", email);
        // call service layer
        boolean result  = userInterface.deleteUser(email);
        if(result){
            return new ResponseEntity<String>("User with email :: " + email + "deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Issue with deletion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
        logger.info("saving user :: {}", userDTO.getUserEmail());
        userInterface.saveUser(userDTO);
        return new ResponseEntity<String>("User saved",HttpStatus.OK);
    }

}
