package com.miramicodigo.pickersdatetime;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerDialog datePicker;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        return datePicker;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
        final int mesActual = mes + 1;
        String diaFormateado = (dia < 10) ? "0"+String.valueOf(dia): String.valueOf(dia);
        String mesFormateado = (mesActual < 10) ? "0"+String.valueOf(mesActual) : String.valueOf(mesActual);
        String resultado = diaFormateado+"/"+mesFormateado+"/"+anio;

        ((DateTimeInterface) getActivity()).obtieneFecha(resultado);
    }

    public Calendar maxRangeDatePicker() {
        String aTime = "2018-02-25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar cal = null;
        try {
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse(aTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }

    public Calendar minRangeDatePicker() {
        String aTime = "2018-02-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar cal = null;
        try {
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse(aTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }
}
