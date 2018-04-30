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
                        "Mensaje", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        btnSnackbarConAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,
                        "Mensaje eliminado", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(),
                                        "OK", Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.show();
            }
        });

        btnSnackbarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,
                        "Mensaje eliminado", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(),
                                        "OK", Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.setActionTextColor(Color.GREEN);

                View sbView = snackbar.getView();
                TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLUE);
                sbView.setBackgroundColor(Color.YELLOW);

                snackbar.show();
            }
        });

    }
}
