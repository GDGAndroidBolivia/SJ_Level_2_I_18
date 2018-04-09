package com.miramicodigo.pickersdatetime;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private TimePickerDialog timePickerDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return timePickerDialog;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
        String horaFormateada = (hora < 10) ? "0"+String.valueOf(hora) : String.valueOf(hora);
        String minutoFormateado = (minuto < 10) ? "0"+String.valueOf(minuto) : String.valueOf(minuto);
        String AM_PM;
        if(hora < 12) {
            AM_PM = "a.m.";
        } else {
            AM_PM = "p.m.";
        }
        String resultado = horaFormateada + ":"+ minutoFormateado+ " "+ AM_PM;

        ((DateTimeInterface) getActivity()).obtieneHora(resultado);
    }


}
