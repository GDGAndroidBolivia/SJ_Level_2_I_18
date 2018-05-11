package com.miramicodigo.fragmentssimple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

	private ImageButton ibBolivia, ibBrasil, ibArgentina;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ibBolivia = (ImageButton) findViewById(R.id.ibBolivia);
		ibBrasil = (ImageButton) findViewById(R.id.ibBrasil);
		ibArgentina = (ImageButton) findViewById(R.id.ibArgentina);

		ibBolivia.setOnClickListener(this);
		ibBrasil.setOnClickListener(this);
		ibArgentina.setOnClickListener(this);

		showFragment(new BoliviaFragment());

	}

	public void showFragment(Fragment fragment) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.fragmentContainer, fragment);
		transaction.commit();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.ibBolivia:
				showFragment(new BoliviaFragment());
				break;
			case R.id.ibBrasil:
				showFragment(new BrasilFragment());
				break;
			case R.id.ibArgentina:
				showFragment(new ArgentinaFragment());
				break;
		}
	}
}