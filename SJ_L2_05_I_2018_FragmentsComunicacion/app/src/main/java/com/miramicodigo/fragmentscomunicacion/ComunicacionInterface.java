package com.miramicodigo.fragmentscomunicacion;

/**
 * Created by Lizarraga on 9/2/2018.
 */

public interface ComunicacionInterface {
    void enviarDatoAUnoFragment(String cadena);

    void enviarDatoADosFragment(String cadena);

    void enviarDatoATresFragment(int num);
}
