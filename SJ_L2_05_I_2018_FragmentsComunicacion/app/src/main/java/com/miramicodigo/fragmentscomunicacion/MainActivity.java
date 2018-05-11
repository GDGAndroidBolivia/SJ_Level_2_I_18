package com.miramicodigo.fragmentscomunicacion;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicacionInterface{

    private Fragment unoFragment, dosFragment, tresFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        unoFragment = new UnoFragment();
        transaction.add(R.id.fragmentUno, unoFragment);

        dosFragment = new DosFragment();
        transaction.add(R.id.fragmentDos, dosFragment);

        tresFragment = new TresFragment();
        transaction.add(R.id.fragmentTres, tresFragment);

        transaction.commit();
    }

    @Override
    public void enviarDatoAUnoFragment(String cadena) {
        ((UnoFragment) unoFragment).llegaDato(cadena);
    }

    @Override
    public void enviarDatoADosFragment(String cadena) {
        ((DosFragment) dosFragment).llegaDato(cadena);
    }

    @Override
    public void enviarDatoATresFragment(int num) {
        ((TresFragment) tresFragment).llegaDato(num);
    }
}