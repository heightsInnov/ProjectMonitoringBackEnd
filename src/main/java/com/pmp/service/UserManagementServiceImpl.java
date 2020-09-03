package com.pmp.service;

import com.pmp.model.PmpResponse;
import com.pmp.model.RegistrationModel;
import com.pmp.model.UserModel;
import com.pmp.repository.UserManagementRepo;
import com.pmp.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    UserManagementRepo loginRepo;

    @Override
    public ResponseEntity<UserModel> userLogin(String username, String password) {
        UserModel userModel = loginRepo.validateUser(username, password);
        if (userModel.isLogin()){
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        }else
            return new ResponseEntity<>(userModel, HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<PmpResponse> userRegistration(RegistrationModel registrationModel) {
        PmpResponse pmpResponse = loginRepo.registration(registrationModel);
        if (pmpResponse.getCode().equals(Constants.SUCCESS))
            return  new ResponseEntity<>(pmpResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(pmpResponse, HttpStatus.BAD_REQUEST);
    }
}
