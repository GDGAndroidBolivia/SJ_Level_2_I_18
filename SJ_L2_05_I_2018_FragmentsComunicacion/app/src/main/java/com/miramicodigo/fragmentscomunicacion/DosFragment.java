package com.miramicodigo.fragmentscomunicacion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DosFragment extends Fragment {

    private TextView tvRespuesta;
    private Button btnDosAUno, btnDosATres;

    public DosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dos, container, false);

        btnDosAUno = (Button) view.findViewById(R.id.btnDosAUno);
        btnDosATres = (Button) view.findViewById(R.id.btnDosATres);
        tvRespuesta = (TextView) view.findViewById(R.id.tvDosRecibido);

        btnDosAUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ComunicacionInterface) getActivity()).enviarDatoAUnoFragment("Enviando de Dos a Uno");
            }
        });

        btnDosATres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ComunicacionInterface) getActivity()).enviarDatoATresFragment(60000);
            }
        });

        return view;
    }

    public void llegaDato(String dato) {
        tvRespuesta.setText(dato);
    }

}
