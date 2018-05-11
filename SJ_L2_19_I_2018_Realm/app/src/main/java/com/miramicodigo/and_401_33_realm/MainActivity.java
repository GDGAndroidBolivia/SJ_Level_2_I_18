package com.miramicodigo.and_401_33_realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miramicodigo.and_401_33_realm.interfaces.LoginView;
import com.miramicodigo.and_401_33_realm.presenter.LoginPresenter;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    private LoginPresenter loginPresenter;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        init();
    }

    private void init() {
        etUser = (EditText) findViewById(R.id.etMainUser);
        etPassword = (EditText) findViewById(R.id.etMainPassword);
        btnLogin = (Button) findViewById(R.id.btnMainLogin);
        btnRegister = (Button) findViewById(R.id.btnMainRegister);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);

        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onClick(View view) {
        loginPresenter.verifyButton(view.getId());
    }

    @Override
    public void success() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Datos correctos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void failure() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void goToRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void verifyField(){
        loginPresenter.verifyFieldEmpty(etUser.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void fieldNotEmpty() {
       loginPresenter.queryUser(realm, etUser.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void fieldEmpty() {
        Toast.makeText(this, "Debe llenar ambos campos", Toast.LENGTH_SHORT).show();
    }
}
