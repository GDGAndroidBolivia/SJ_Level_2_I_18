package com.miramicodigo.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static Button btnIniciar, btnReiniciar, btnPausar;
    private static TextView tvCronometro;
    private Cronometro cronometro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button)findViewById(R.id.btnIniciar);
        btnReiniciar = (Button)findViewById(R.id.btnReiniciar);
        btnPausar = (Button)findViewById(R.id.btnPausar);
        tvCronometro = (TextView)findViewById(R.id.tvCronometro);

        btnIniciar.setOnClickListener(this);
        btnReiniciar.setOnClickListener(this);
        btnPausar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnIniciar:

                break;
            case R.id.btnReiniciar:

                break;
            case R.id.btnPausar:

                break;
        }
    }
}
