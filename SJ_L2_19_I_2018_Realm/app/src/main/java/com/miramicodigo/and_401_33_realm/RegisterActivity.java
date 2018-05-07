package com.miramicodigo.and_401_33_realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miramicodigo.and_401_33_realm.interfaces.RegisterView;
import com.miramicodigo.and_401_33_realm.presenter.RegisterPresenter;

import io.realm.Realm;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, RegisterView {

    private EditText etUser;
    private EditText etPassword;
    private Button btnRegister;
    private Realm realm;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registro");

        initializeComponentes();
    }

    private void initializeComponentes() {
        etUser = findViewById(R.id.etRegisterUser);
        etPassword = findViewById(R.id.etRegisterPassword);
        btnRegister = findViewById(R.id.btnRegisterRegistrar);
        btnRegister.setOnClickListener(this);

        realm = Realm.getDefaultInstance();
        registerPresenter = new RegisterPresenter(this);
    }

    @Override
    public void onClick(View view) {
        registerPresenter.verifyFieldEmpty(etUser.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void registerUser() {
        registerPresenter.registerUser(realm, etUser.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void success() {
        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void failure() {
        Toast.makeText(this, "Ya existe un usuario repetido", Toast.LENGTH_LONG).show();
    }

    @Override
    public void fieldEmpty() {
        Toast.makeText(this, "Debe llenar ambos campos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fieldNotEmpty() {
        registerUser();
    }
}
