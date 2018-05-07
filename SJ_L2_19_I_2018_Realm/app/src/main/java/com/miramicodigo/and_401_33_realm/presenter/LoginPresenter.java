package com.miramicodigo.and_401_33_realm.presenter;

import com.miramicodigo.and_401_33_realm.interfaces.LoginView;
import com.miramicodigo.and_401_33_realm.R;
import com.miramicodigo.and_401_33_realm.model.User;

import java.util.Collection;

import io.realm.Realm;

public class LoginPresenter {

    private LoginView loginView;
    private Boolean sucessLogin;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void verifyButton(int oneButton) {
        switch (oneButton) {
            case R.id.btnMainLogin:
                loginView.verifyField();
                break;
            case R.id.btnMainRegister:
                loginView.goToRegister();
                break;
        }
    }

    public void verifyFieldEmpty(String user, String password) {
        if (user.isEmpty() || password.isEmpty()) {
            loginView.fieldEmpty();
        } else {
            loginView.fieldNotEmpty();
        }
    }

    public void queryUser(Realm realm, String userName, String password) {
        sucessLogin = Boolean.FALSE;



        if(sucessLogin) {
            loginView.success();
        }else{
            loginView.failure();
        }
    }
}
