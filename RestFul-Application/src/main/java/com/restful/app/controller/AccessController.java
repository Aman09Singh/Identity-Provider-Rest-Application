package com.restful.app.controller;

import com.restful.app.model.ResponseObject;
import com.restful.app.model.UserAuthDTO;
import com.restful.app.service.implementation.AuthServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public ResponseEntity<EntityModel<ResponseObject>> authenticateUserAndGenerateHeader(@RequestBody UserAuthDTO userAuthDTO){

        ResponseObject responseObject = authService.returnAuthenticatedHeader(userAuthDTO);

        EntityModel<ResponseObject> responseObjectEntity =  EntityModel.of(responseObject);
        responseObjectEntity.add(linkTo(methodOn(AccessController.class).authenticateUserAndGenerateHeader(userAuthDTO)).withSelfRel());

        return new ResponseEntity<EntityModel<ResponseObject>>(responseObjectEntity, HttpStatus.OK);

    }
}
