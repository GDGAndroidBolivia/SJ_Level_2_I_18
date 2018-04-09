package com.miramicodigo.fullscreendialog;

import android.app.Dialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FullscreenDialog extends DialogFragment {

    private EditText etNombre;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_fullscreen, container, false);




        etNombre = (EditText) view.findViewById(R.id.etNombre);

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fullscreen_dialog, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuFullscreenGuardar:
                guardarDatos();
                break;
            case android.R.id.home:
                dismiss();
                break;
        }
        return true;
    }

    public void guardarDatos() {
        String nombre = etNombre.getText().toString();
        ((DialogFullscreenInterface) getActivity()).guardaFormulario(nombre);
        dismiss();
    }

}
