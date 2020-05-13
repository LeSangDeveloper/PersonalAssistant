package android.example.demolistviewplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddWorkActivity extends AppCompatActivity {

    private EditText EditTextHour, EditTextWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);

        EditTextHour = (EditText)findViewById(R.id.editTextHour);
        EditTextWork = (EditText)findViewById(R.id.editTextTitle);
    }


    public void btnFinish(View view){
        finish();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("hour", EditTextHour.getText().toString());
        data.putExtra("work", EditTextWork.getText().toString());
        setResult(RESULT_OK, data);
        super.finish();
    }

}
