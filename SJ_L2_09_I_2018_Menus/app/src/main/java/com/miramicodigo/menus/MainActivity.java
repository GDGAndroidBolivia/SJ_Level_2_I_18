package com.miramicodigo.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnShowPopup;
    private ListView lvDatos;
    private List<String> datos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDatos = (ListView) findViewById(R.id.lvDatos);
        btnShowPopup = (Button) findViewById(R.id.btnPopup);
        btnShowPopup.setOnClickListener(this);

        llenarDatos();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, datos);
        lvDatos.setAdapter(adapter);

    }

    public void llenarDatos() {
        datos = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datos.add("Elemento "+ (i+1)+" de la lista.");
        }
    }

    @Override
    public void onClick(View view) {

    }

}
