package com.miramicodigo.menus;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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

    // Menu de opciones -> Toolbar.
    // Menu contextuales -> Se posicionan al centro de la pantalla o Toolbar.
    // Menu Popup -> Se posiciona de acuerdo al elemento que se hizo click.

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

        registerForContextMenu(lvDatos);

    }

    public void llenarDatos() {
        datos = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datos.add("Elemento "+ (i+1)+" de la lista.");
        }
    }

    @Override
    public void onClick(View view) {
        final PopupMenu popupMenu = new PopupMenu(getApplicationContext(), btnShowPopup);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuPopUno:
                        Toast.makeText(getApplicationContext(), "Popup 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menuPopDos:
                        Toast.makeText(getApplicationContext(), "Popup 2", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menuPopTres:
                        Toast.makeText(getApplicationContext(), "Popup 3", Toast.LENGTH_SHORT).show();
                        return true;
                        default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOpUno:
                Toast.makeText(getApplicationContext(),
                        "Menu uno", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuOpDos:
                Toast.makeText(getApplicationContext(),
                        "Menu dos", Toast.LENGTH_LONG).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuConUno:
                Toast.makeText(getApplicationContext(), "Opc 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuConDos:
                Toast.makeText(getApplicationContext(), "Opc 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuConTres:
                Toast.makeText(getApplicationContext(), "Opc 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuConCuatro:
                Toast.makeText(getApplicationContext(), "Opc 4", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
