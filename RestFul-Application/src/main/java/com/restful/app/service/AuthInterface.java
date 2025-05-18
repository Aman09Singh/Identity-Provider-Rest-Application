package com.restful.app.service;

import com.restful.app.model.ResponseObject;
import com.restful.app.model.UserAuthDTO;

public interface AuthInterface {

    ResponseObject returnAuthenticatedHeader(UserAuthDTO userAuthDTO);
}
