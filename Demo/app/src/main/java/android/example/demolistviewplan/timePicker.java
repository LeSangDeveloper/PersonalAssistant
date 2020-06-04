package android.example.demolistviewplan;

import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

public class timePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanced) {
        Calendar c = Calendar.getInstance();
        int cHour = c.get(Calendar.HOUR_OF_DAY);
        int cMinute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, cHour, cMinute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (getActivity() instanceof EditWorkActivity)
        {
            EditWorkActivity activity = (EditWorkActivity)getActivity();
            activity.processTimePickerResult(hourOfDay, minute);
        }
        else if (getActivity() instanceof  AddWorkActivity)
        {
            AddWorkActivity activity = (AddWorkActivity)getActivity();
            activity.processTimePickerResult(hourOfDay, minute);
        }
    }
}
