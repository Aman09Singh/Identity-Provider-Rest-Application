package com.restful.app.controller;

import com.restful.app.model.UserDTO;
import com.restful.app.service.implementation.UserInterfaceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserInterfaceImpl userInterface;

    public UserController(UserInterfaceImpl userInterface) {
        this.userInterface = userInterface;
    }

    @DeleteMapping("/delete/{email}")
    @Operation(summary = "Deletes user by their email",
                description = "Returns the proper response to deleting the user")
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

    @PostMapping("/save")
    @Operation(summary = "Saves a user",
            description = "Saves a user and returns the same user")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
        logger.info("saving user :: {}", userDTO.getUserEmail());
        userInterface.saveUser(userDTO);
        return new ResponseEntity<String>("User saved",HttpStatus.OK);
    }

}
