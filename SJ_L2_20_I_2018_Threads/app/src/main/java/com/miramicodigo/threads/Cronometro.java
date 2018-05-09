package com.miramicodigo.threads;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class Cronometro implements Runnable {
    private TextView textView;
    private String nombrecronometro;
    private int segundos, minutos, horas;
    private Handler escribirenUI;
    private Boolean pausado;
    private String salida;

    public Cronometro(String nombre, TextView etiqueta) {
        textView = etiqueta;
        salida = "";
        segundos = 0;
        minutos = 0;
        horas = 0;
        nombrecronometro = nombre;
        escribirenUI = new Handler();
        pausado = Boolean.FALSE;
    }

    @Override
    public void run() {
        try {
            while(Boolean.TRUE) {
                Thread.sleep(1000);
                salida = "";
                if( !pausado ) {
                    segundos++;
                    if(segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                    if(minutos == 60) {
                        minutos = 0;
                        horas++;
                    }
                    salida += "0";
                    salida += horas;
                    salida += ":";
                    if( minutos <= 9 ) {
                        salida += "0";
                    }
                    salida += minutos;
                    salida += ":";
                    if( segundos <= 9 ) {
                        salida += "0";
                    }
                    salida += segundos;
                    try {
                        escribirenUI.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(salida);
                            }
                        });
                    }
                    catch (Exception e) {
                        Log.i("Cronometro", "Error en el cronometro " + nombrecronometro + " al escribir en la UI: " + e.toString());
                    }
                }
            }
        }
        catch (InterruptedException e) {
            Log.i("Cronometro", "Error en el cronometro " + nombrecronometro + ": " + e.toString());
        }
    }

    public void reiniciar() {
        segundos = 0;
        minutos = 0;
        horas = 0;
        pausado = Boolean.FALSE;
    }

    public void pause() {
        pausado = !pausado;
    }

}
