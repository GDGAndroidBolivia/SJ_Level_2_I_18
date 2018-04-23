package com.miramicodigo.recyclerviewcards;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private ImageView ivImagen;
    private TextView tvTitulo;
    private TextView tvSubtitulo;
    private Typeface tf_black;
    private Typeface tf_thin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvTitulo = (TextView) findViewById(R.id.tvDetalleNombre);
        tvSubtitulo = (TextView) findViewById(R.id.tvDetalleHabilidades);
        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);

        tf_black = Typeface.createFromAsset(getAssets(), "fonts/roboto_black.ttf");
        tf_thin = Typeface.createFromAsset(getAssets(), "fonts/roboto_thin.ttf");

        tvTitulo.setTypeface(tf_black);
        tvSubtitulo.setTypeface(tf_thin);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("poke");
        tvTitulo.setText(pokemon.getNombre());
        tvSubtitulo.setText(pokemon.getTipo());
        ivImagen.setImageResource(pokemon.getImagen());
    }
}











