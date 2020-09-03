package com.pmp.repository;

import com.pmp.model.PmpResponse;
import com.pmp.model.RegistrationModel;
import com.pmp.model.UserModel;
import com.pmp.utility.ValidationUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static com.pmp.utility.Constants.*;/**/

@Repository("LoginRepo")
public class UserManagementRepoImpl implements UserManagementRepo {

    protected Map<String, String> registeredUsers = new HashMap<>();
    protected Map<String, String[]> userRoles = new HashMap<>();
    protected Map<String, RegistrationModel> registration = new HashMap<>();

    ValidationUtil validationUtil = new ValidationUtil();

    UserManagementRepoImpl() {
        registeredUsers.put("ayotola", "tallertalk");
        registeredUsers.put("testuser", "testing@123");
        registeredUsers.put("usanga", "precious@123");

        userRoles.put("ayotola", new String[]{"ADMIN", "USER"});
        userRoles.put("testuser", new String[]{"USER"});
        userRoles.put("usanga", new String[]{"ADMIN"});
    }

    private boolean authenticate(String username, String password) {
        if (registeredUsers.containsKey(username)) {
            return registeredUsers.get(username).equals(password);
        } else
            return false;
    }

    @Override
    public UserModel validateUser(String username, String password) {
        UserModel userModel = new UserModel(username, authenticate(username, password));
        if (userModel.isLogin()) {
            userModel.setRoles(userRoles.get(username));
        }
        return userModel;
    }

    @Override
    public PmpResponse registration(RegistrationModel registrationModel) {

        PmpResponse response = new PmpResponse(FAILED, "Failed");

        boolean isNull = ValidationUtil.checkFieldsIsNull(registrationModel, registrationModel.validationFields());

        if (!isNull) {
            if (registeredUsers.containsKey(registrationModel.getUsername()))
                response = new PmpResponse(EXISTING_USER, "Existing User");
            else if (registrationModel.getPassword().equals(registrationModel.getConfirmPassword()))
                response = new PmpResponse(PASSWORD_ERROR, "Password Error");
            else {
                registration.put(registrationModel.getUsername(), registrationModel);
                registeredUsers.put(registrationModel.getUsername(), registrationModel.getPassword());
                assignRole(registrationModel);
                response = new PmpResponse(SUCCESS, "Success");
            }
        }
        return response;
    }

    protected void assignRole(RegistrationModel registrationModel) {
        switch (registrationModel.getDesignation()) {
            case STAFF:
                userRoles.put(registrationModel.getUsername(), new String[]{ADMIN});
                break;
            case BUDGET_APPROVER:
                userRoles.put(registrationModel.getUsername(), new String[]{BUDGET_APPROVER, USER});
                break;
            case PROJECT_APPROVER:
                userRoles.put(registrationModel.getUsername(), new String[]{PROJECT_APPROVER, USER});
                break;
            default:
                userRoles.put(registrationModel.getUsername(), new String[]{USER});
        }
    }
}
