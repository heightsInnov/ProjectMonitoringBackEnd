package com.pmp.controller;

import com.pmp.model.LoginModel;
import com.pmp.model.PmpResponse;
import com.pmp.model.RegistrationModel;
import com.pmp.model.UserModel;
import com.pmp.service.UserManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/pmp")
public class UserManagementController {

    @Autowired
    UserManagementServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<UserModel> authenticate(@RequestBody LoginModel loginModel) {
        return loginService.userLogin(loginModel.getUsername(), loginModel.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<PmpResponse> registerUser(@RequestBody RegistrationModel registrationModel) {
        return loginService.userRegistration(registrationModel);
    }
}
