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
        final Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker = new DatePickerDialog(getActivity(), this, anio, mes, dia);

        datePicker.getDatePicker().setMinDate(minRangeDatePicker().getTimeInMillis());
        datePicker.getDatePicker().setMaxDate(maxRangeDatePicker().getTimeInMillis());

        return datePicker;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {

        System.out.println(anio+""+mes+""+dia);

        final int mesActual = mes + 1;
        String diaFormateado = (dia < 10) ? "0"+String.valueOf(dia): String.valueOf(dia);
        String mesFormateado = (mesActual < 10) ? "0"+String.valueOf(mesActual) : String.valueOf(mesActual);
        String resultado = diaFormateado+"/"+mesFormateado+"/"+anio;

        ((DateTimeInterface) getActivity()).obtieneFecha(resultado);
    }

    public Calendar maxRangeDatePicker() {
        String aTime = "2018-04-15";
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
        String aTime = "2018-04-11";
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
