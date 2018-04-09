package com.miramicodigo.fullscreendialog;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogFullscreenInterface {

    private Button btnFullscreenDialog;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        btnFullscreenDialog = (Button) findViewById(R.id.btnAbrirFullscreenDialog);
        tvResultado = (TextView) findViewById(R.id.tvResultadoFullscreenDialog);

        btnFullscreenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialog();
            }
        });
    }

    public void mostrarDialog() {

    }

    @Override
    public void guardaFormulario(String nombre) {
        tvResultado.setText(nombre);
    }
}
