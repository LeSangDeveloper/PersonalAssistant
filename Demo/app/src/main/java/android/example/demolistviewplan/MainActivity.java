package android.example.demolistviewplan;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> mWorkHour = new ArrayList<String>();
    private ArrayList<String> mWorkTitle = new ArrayList<String>();
    private WorkAdapter adapter;

    private TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mWorkHour.add("7:00");
        mWorkHour.add("11:00");
        mWorkTitle.add("Đi học");
        mWorkTitle.add("Đi chơi");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = (TextView)findViewById(R.id.txtDate);

        adapter = new WorkAdapter(this, mWorkHour, mWorkTitle);
        listView = (ListView)findViewById(R.id.listWork);

        listView.setAdapter(adapter);

    }

    public void addWork(View view)
    {
        Intent intent = new Intent(this, AddWorkActivity.class);

        int REQUEST_CODE = 9;
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        String hour = null;
        String title = null;
        if (resultCode == RESULT_OK && requestCode == 9) {
            if (data.hasExtra("hour")) {
                hour = data.getExtras().getString("hour");
                title = data.getExtras().getString("work");
            }
        }

        mWorkHour.add(hour);

        mWorkTitle.add(title);

    }

    public void chooseDate(View view)
    {
        DialogFragment dateFragment = new datePicker();
        dateFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = ( day_string + "/" + month_string + "/" + year_string);

        txtDate.setText(dateMessage);

        Toast.makeText(this, Environment.getDataDirectory().toString(),
                Toast.LENGTH_SHORT).show();
    }

}
