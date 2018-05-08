package com.miramicodigo.bottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bnvMain);

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment = new MenuUnoFragment();
        transaction.replace(R.id.frameContent, fragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemUno:
                        fragment = new MenuUnoFragment();
                        break;
                    case R.id.itemDos:
                        fragment = new MenuDosFragment();
                        break;
                    case R.id.itemTres:
                        fragment = new MenuTresFragment();
                        break;
                }
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameContent, fragment).commit();
                return true;
            }
        });

    }

}
