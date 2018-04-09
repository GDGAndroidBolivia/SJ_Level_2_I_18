package com.miramicodigo.pickersdatetime;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements DateTimeInterface{

    private ImageButton ibFecha, ibHora;
    private EditText etFecha, etHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibFecha = (ImageButton) findViewById(R.id.ibFecha);
        ibHora = (ImageButton) findViewById(R.id.ibHora);

        etFecha = (EditText) findViewById(R.id.etFecha);
        etHora = (EditText) findViewById(R.id.etHora);

        ibFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(view);
            }
        });

        ibHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view);
            }
        });

    }

    public void showTimePickerDialog(View v) {



    }

    public void showDatePickerDialog(View v) {



    }

    @Override
    public void obtieneFecha(String date) {
        etFecha.setText(date);
    }

    @Override
    public void obtieneHora(String hour) {
        etHora.setText(hour);
    }
}
