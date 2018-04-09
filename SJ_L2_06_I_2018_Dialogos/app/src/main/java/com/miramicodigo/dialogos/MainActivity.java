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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Mi Dialogo")
                .setMessage("Este es el contenido de mi dialogo")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Aceptar",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Cancelar",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Cerrar",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        return alertDialog.create();
    }


    public AlertDialog crearDialogoConLista() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        final String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Opcion 6", "Opcion 7", "Opcion 8"};
        alertDialog.setTitle("Elija una opcion")
                .setCancelable(false)
                .setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),
                                "Hizo click en: "+ opciones[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return alertDialog.create();
    }

    public AlertDialog crearDialogoConListaRadio() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        final String [] opciones = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"};
        posicion = 0;
        alertDialog.setTitle("Seleccione una opcion")
                .setSingleChoiceItems(opciones, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        posicion = i;
                    }
                })
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),
                                "Seleccionaste: "+ opciones[posicion], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return alertDialog.create();
    }

    public AlertDialog crearDialogoCheckBox() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        final String[] opciones = {"Desarrollo Android", "Desarrollo iOS", "Back-end", "Front-end"};
        final ArrayList<Integer> itemsSeleccionados = new ArrayList<Integer>();

        alertDialog.setTitle("Seleccione sus Skills")
                .setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b) {
                            itemsSeleccionados.add(i);
                        } else {
                            if(itemsSeleccionados.contains(i)) {
                                itemsSeleccionados.remove(Integer.valueOf(i));
                            }
                        }
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String res = "";
                        for (int j = 0; j < itemsSeleccionados.size(); j++) {
                            res = res +"\n- "+opciones[itemsSeleccionados.get(j)];
                        }
                        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                    }
                });
        return alertDialog.create();
    }

    public AlertDialog crearDialogoPersonalizado() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(false);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.custom_dialog, null);
        alertDialog.setView(v);

        btnCrear = v.findViewById(R.id.btnCrear);
        btnEntrar = v.findViewById(R.id.btnEntrar);
        etNombre = v.findViewById(R.id.etNombre);
        etContrasenia = v.findViewById(R.id.etContrasenia);
        cbRecordar = v.findViewById(R.id.cbRecordar);

        final AlertDialog dialog = alertDialog.show();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        res = "";
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = "Nombre: "+etNombre.getText().toString()+
                        "\nRecordar: "+cbRecordar.isChecked();
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        return alertDialog.create();
    }
}
