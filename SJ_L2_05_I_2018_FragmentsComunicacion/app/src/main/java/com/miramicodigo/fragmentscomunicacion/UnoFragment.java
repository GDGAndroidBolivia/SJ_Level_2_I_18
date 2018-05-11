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
public class UnoFragment extends Fragment {

    private TextView tvRespuesta;
    private Button btnUnoADos, btnUnoATres;

    public UnoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        btnUnoADos = (Button) view.findViewById(R.id.btnUnoADos);
        btnUnoATres = (Button) view.findViewById(R.id.btnUnoATres);
        tvRespuesta = (TextView) view.findViewById(R.id.tvUnoRecibido);

        btnUnoADos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ComunicacionInterface) getActivity())
                        .enviarDatoADosFragment("Enviando de Uno a Dos");
            }
        });

        btnUnoATres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ComunicacionInterface) getActivity()).enviarDatoATresFragment(5000);
            }
        });

        return view;
    }

    public void llegaDato(String dato) {
        tvRespuesta.setText(dato);
    }

}
