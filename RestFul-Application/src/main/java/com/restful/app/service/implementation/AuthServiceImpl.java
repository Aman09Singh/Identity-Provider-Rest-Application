package com.restful.app.service.implementation;

import com.restful.app.model.ResponseObject;
import com.restful.app.model.UserAuthDTO;
import com.restful.app.model.UserDTO;
import com.restful.app.repository.UserManagementRepository;
import com.restful.app.service.AuthInterface;
import com.restful.app.util.JWTUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthInterface {

    private final UserManagementRepository userManagementRepository;

    private final JWTUtil jwtUtil;

    public AuthServiceImpl(UserManagementRepository userManagementRepository, JWTUtil jwtUtil) {
        this.userManagementRepository = userManagementRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ResponseObject returnAuthenticatedHeader(UserAuthDTO userAuthDTO) {

        Optional<UserDTO> userDTO = userManagementRepository.findByUserName(userAuthDTO.getUserName());
        if(userDTO.isEmpty()){
            return new ResponseObject(userAuthDTO.getUserName(),"User Not Found. Please register the user if required");
        }else{
            UserDTO userDTOResult = userDTO.get();
            return new ResponseObject(userDTOResult.getUserEmail(),userDTOResult.getUserName(),"Bearer " + jwtUtil.generateJWToken(userDTOResult),"Header valid for an hour");
        }

    }

}
