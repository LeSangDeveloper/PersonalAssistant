package android.example.demolistviewplan;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class datePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it.
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        MainActivity activity = (MainActivity) getActivity();
        String dateMessage = activity.convertDateToString(year, month - 1, day);
        activity.processDatePickerResult(dateMessage);
        activity.setWorksToDay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity activity = (MainActivity) getActivity();
        activity.setWorksToDay();
    }
}
