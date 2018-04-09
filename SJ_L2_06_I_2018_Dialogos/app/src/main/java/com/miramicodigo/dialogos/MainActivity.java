package com.miramicodigo.dialogos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnDialogoSimple, btnDialogoConLista, btnDialogoConListaRadio, btnDialogoConListaCheckbox, btnDialogoPersonalizado;
    private Button btnCrear, btnEntrar;
    private EditText etNombre, etContrasenia;
    private CheckBox cbRecordar;
    private int posicion;
    private String res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialogoSimple = (Button) findViewById(R.id.btnDialogoSimple);
        btnDialogoConLista = (Button) findViewById(R.id.btnDialogoConLista);
        btnDialogoConListaRadio = (Button) findViewById(R.id.btnDialogoConListaRadio);
        btnDialogoConListaCheckbox = (Button) findViewById(R.id.btnDialogoConListaCheckbox);
        btnDialogoPersonalizado = (Button) findViewById(R.id.btnDialogoPersonalizado);

        btnDialogoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDialogoSimple().show();
            }
        });

        btnDialogoConLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDialogoConLista().show();
            }
        });

        btnDialogoConListaRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDialogoConListaRadio().show();
            }
        });

        btnDialogoConListaCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDialogoCheckBox().show();
            }
        });

        btnDialogoPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDialogoPersonalizado();
            }
        });

    }

    public AlertDialog crearDialogoSimple() {
        return null;
    }


    public AlertDialog crearDialogoConLista() {
        return null;
    }

    public AlertDialog crearDialogoConListaRadio() {
        return null;
    }

    public AlertDialog crearDialogoCheckBox() {
        return null;
    }

    public AlertDialog crearDialogoPersonalizado() {
        return null;
    }

}
