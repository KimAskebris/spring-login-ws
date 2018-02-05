package com.service.login.endpoint;

import com.kimper.login.LoginRequest;
import com.kimper.login.LoginResponse;
import com.service.login.model.User;
import com.service.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginEndpoint {
    
     private static final String NAMESPACE_URI = "http://www.kimper.com/login";
    
    @Autowired
    UserRepository userRepository;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) {
        LoginResponse response = new LoginResponse();
        User user = userRepository.findByName(request.getUsername());
        if (user != null) {
            if (user.getPassword().equals(request.getPassword())) {
                response.setAuthorized(true);
            } else {
            response.setAuthorized(false);
            response.setError("Wrong password");
           }
        } else {
            response.setAuthorized(false);
            response.setError("Wrong username");
        }
        return response;
    }
    
}
