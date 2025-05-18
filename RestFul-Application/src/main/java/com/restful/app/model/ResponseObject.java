package com.restful.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {

    private String userEmail;
    private String userName;
    private String bearerHeader;
    private String message;

    public ResponseObject(String userName, String message){
        this.userName = userName;
        this.message = message;
    }
}
