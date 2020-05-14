package android.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {

    private WorksDataSource datasource;
    private ListView listView;
    private ArrayList<String> mWorkHour = new ArrayList<String>();
    private ArrayList<String> mWorkTitle = new ArrayList<String>();
    private ArrayList<String> mWorkDate = new ArrayList<String>();

    private WorkAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource = new WorksDataSource(this);
        datasource.open();

        listView = (ListView)findViewById(android.R.id.list);

        List<Work> values = datasource.getAllWork();

        for (Work work:values)
        {
            mWorkHour.add(work.getTime());
            mWorkTitle.add(work.getTitle());
        }


        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        adapter = new WorkAdapter(this, mWorkHour, mWorkTitle, mWorkDate);
        setListAdapter(adapter);
    }

    // Tạo sự kiện khi click vào các nút trong activity_main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        Work work = null;
        switch (view.getId()) {
            // Thêm người vào danh sách.
            case R.id.add:
                String[] workTitle = new String[]{"Đi học", "Đi ăn", "Đi chơi"};
                String[] workDate = new String[]{"22/10/2020", "12/10/2020", "31/10/2020"};
                String[] workTime = new String[]{"2:30", "7:00", "18:00"};
                int nextInt = new Random().nextInt(3);
                work = datasource.createWork(workTitle[nextInt], workDate[nextInt], workTime[nextInt]);
                String workString = workTitle[nextInt].toString() + " " + workDate[nextInt].toString() + " " + workTime[nextInt].toString() + " . ";
                Toast.makeText(getApplicationContext(), workString, Toast.LENGTH_LONG).show();
                mWorkHour.add(workTime[nextInt].toString());
                mWorkTitle.add(workTitle[nextInt].toString());
                break;
            // Xóa người đầu tiên khỏi danh sách.
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    work = (Work) getListAdapter().getItem(0);
                    datasource.deleteWork(work);
                    adapter.remove(work);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}
