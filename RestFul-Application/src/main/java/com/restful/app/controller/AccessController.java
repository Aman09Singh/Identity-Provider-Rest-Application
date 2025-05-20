package com.restful.app.controller;

import com.restful.app.model.ResponseObject;
import com.restful.app.model.UserAuthDTO;
import com.restful.app.model.UserDTO;
import com.restful.app.service.implementation.AuthServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AccessController {

    @Autowired
    private final AuthServiceImpl authService;

    public AccessController(AuthServiceImpl authService) {
        this.authService = authService;
    }
    
    @PostMapping("/validate")
    @Operation(summary = "Authenticates user",
            description = "Authenticates user and returns an object with the Authorization header")
    public ResponseEntity<ResponseObject> authenticateUserAndGenerateHeader(@RequestBody UserAuthDTO userAuthDTO){
        ResponseObject responseObject = authService.returnAuthenticatedHeader(userAuthDTO);
        return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);

    }
}
