package android.example.demolistviewplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class InstructionActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private IntroAdapter introAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        getSupportActionBar().hide();

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        IntroAdapter introAdapter = new IntroAdapter(getSupportFragmentManager());
        viewPager.setAdapter(introAdapter);
    }
}
