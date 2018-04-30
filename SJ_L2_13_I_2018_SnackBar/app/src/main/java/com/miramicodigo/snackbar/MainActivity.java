package com.miramicodigo.snackbar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private Button btnSnackbarSimple, btnSnackbarConAccion, btnSnackbarColor;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSnackbarSimple = (Button) findViewById(R.id.btnSnackbarSimple);
        btnSnackbarConAccion = (Button) findViewById(R.id.btnSnackbarConAccion);
        btnSnackbarColor = (Button) findViewById(R.id.btnSnackbarColor);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        btnSnackbarSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,
                        "Snackbak Simple", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        btnSnackbarConAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,
                        "No hay conexion a internet", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Reintentar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                snackbar.show();
            }
        });

        btnSnackbarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,
                        "Snackbar personalizado", Snackbar.LENGTH_LONG);
                snackbar.setAction("Accion", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                snackbar.setActionTextColor(Color.BLUE);
                View sb = snackbar.getView();
                TextView tv = sb.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.RED);
                sb.setBackgroundColor(Color.GREEN);

                snackbar.show();
            }
        });

    }
}
