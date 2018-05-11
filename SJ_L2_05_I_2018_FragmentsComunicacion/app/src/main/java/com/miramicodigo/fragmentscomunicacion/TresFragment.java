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
public class TresFragment extends Fragment {

    private TextView tvRespuesta;
    private Button btnTresAUno, btnTresADos;

    public TresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tres, container, false);

        btnTresAUno = (Button) view.findViewById(R.id.btnTresAUno);
        btnTresADos = (Button) view.findViewById(R.id.btnTresADos);
        tvRespuesta = (TextView) view.findViewById(R.id.tvTresRecibido);

        btnTresAUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ComunicacionInterface) getActivity()).enviarDatoAUnoFragment("Enviando de Tres a Uno");
            }
        });

        btnTresADos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ComunicacionInterface) getActivity()).enviarDatoADosFragment("Enviando de Tres a Dos");
            }
        });

        return view;
    }

    public void llegaDato(int num) {
        tvRespuesta.setText(num+"");
    }

}
