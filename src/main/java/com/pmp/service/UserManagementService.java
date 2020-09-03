package com.pmp.service;

import com.pmp.model.PmpResponse;
import com.pmp.model.RegistrationModel;
import com.pmp.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserManagementService {
    ResponseEntity<UserModel> userLogin(String username, String password);
    ResponseEntity<PmpResponse> userRegistration(RegistrationModel registrationModel);
}
