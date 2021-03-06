package com.example.axel.drawer;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                true);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        TextView tv1=(TextView) getActivity().findViewById(R.id.add_time);
        String hour = String.format("%d",hourOfDay);
        String min = String.format("%d",minute);
        if(hourOfDay < 10) {
            hour = "0" + hour;
        }
        if(minute < 10) {
            min = "0" + min;
        }

        tv1.setText(hour+":"+min);
        //tv1.setText(view.getCurrentHour()+":"+view.getCurrentMinute());

    }
}
