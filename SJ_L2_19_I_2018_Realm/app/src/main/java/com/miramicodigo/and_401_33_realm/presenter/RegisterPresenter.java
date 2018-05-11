package com.miramicodigo.and_401_33_realm.presenter;

import com.miramicodigo.and_401_33_realm.interfaces.RegisterView;
import com.miramicodigo.and_401_33_realm.model.User;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class RegisterPresenter {
    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
    }

    public void verifyFieldEmpty(String user, String password) {
        if (user.isEmpty() || password.isEmpty()) {
            registerView.fieldEmpty();
        } else {
            registerView.fieldNotEmpty();
        }
    }

    public void registerUser(Realm realm, String user, String password){
        try {
            realm.beginTransaction();
            realm.copyToRealm(new User(user, password));
            realm.commitTransaction();
            registerView.success();
        } catch (RealmPrimaryKeyConstraintException e) {
            realm.cancelTransaction();
            registerView.failure();
        }
    }
}
