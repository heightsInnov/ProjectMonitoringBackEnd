package com.pmp.repository;

import com.pmp.model.PmpResponse;
import com.pmp.model.RegistrationModel;
import com.pmp.model.UserModel;

public interface UserManagementRepo {
    UserModel validateUser(String username, String password);
    PmpResponse registration(RegistrationModel registrationModel);

}
