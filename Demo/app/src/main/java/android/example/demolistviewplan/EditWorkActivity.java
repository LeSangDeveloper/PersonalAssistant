package android.example.demolistviewplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditWorkActivity extends AppCompatActivity {
    private EditText EditTextWork, EditTextLocation;
    private TextView EditTextHour;
    private RadioButton notifyNone, notify5Min, notify30Min, notify60Min;
    private String time, title, location, notification;

    private String id, indexOfWorks, indexOfWorkAdapter;

    private void assign()
    {
        EditTextHour = (TextView) findViewById(R.id.editTextHour);
        EditTextWork = (EditText)findViewById(R.id.editTextTitle);
        EditTextLocation = (EditText)findViewById(R.id.editTextLocation);

        notifyNone = (RadioButton)findViewById(R.id.notifyNone);
        notify5Min = (RadioButton)findViewById(R.id.notify5Min);
        notify30Min = (RadioButton)findViewById(R.id.notify30Min);
        notify60Min = (RadioButton)findViewById(R.id.notify60Min);
    }

    private void getAndSet()
    {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        time = intent.getStringExtra("time");
        title = intent.getStringExtra("title");
        location = intent.getStringExtra("location");
        notification = intent.getStringExtra("notification");
        indexOfWorks = intent.getStringExtra("indexOfWorks");
        indexOfWorkAdapter = intent.getStringExtra("indexOfWorkAdapter");

        EditTextHour.setText(time);
        EditTextWork.setText(title);
        EditTextLocation.setText(location);
        if (notification.contains("none"))
        {
            notifyNone.setChecked(true);
        }
        else if (notification.contains("5"))
        {
            notify5Min.setChecked(true);
        }
        else if (notification.contains("30"))
        {
            notify30Min.setChecked(true);
        }
        else if (notification.contains("60"))
        {
            notify60Min.setChecked(true);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_detail);

        assign();

        getAndSet();
    }

    public void btnFinish(View view){
        finish();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("activity", "edit");
        data.putExtra("hour", EditTextHour.getText().toString());
        data.putExtra("work", EditTextWork.getText().toString());
        data.putExtra("location", EditTextLocation.getText().toString());
        data.putExtra("id", id);
        data.putExtra("indexOfWorks", indexOfWorks);
        data.putExtra("indexOfWorkAdapter", indexOfWorkAdapter);

        if (notifyNone.isChecked())
        {
            data.putExtra("notification", "none");
        }
        else if (notify5Min.isChecked())
        {
            data.putExtra("notification", "5");
        }
        else if (notify30Min.isChecked())
        {
            data.putExtra("notification", "30");
        }
        else if (notify60Min.isChecked())
        {
            data.putExtra("notification", "60");
        }

        setResult(RESULT_OK, data);
        super.finish();
    }

    public void chooseTime(View view)
    {
        androidx.fragment.app.DialogFragment timePicker = new timePicker();
        timePicker.show(getSupportFragmentManager(), "time picker");
    }

    public void processTimePickerResult(int hour, int minute)
    {
        String stringHour, stringMinute;
        if (hour < 10)
        {
            stringHour = "0" + hour;
        }
        else
        {
            stringHour = String.valueOf(hour);
        }

        if (minute < 10)
        {
            stringMinute = "0" + minute;
        }
        else
        {
            stringMinute = String.valueOf(minute);
        }

        EditTextHour.setText(stringHour + ":" + stringMinute);
    }

}
