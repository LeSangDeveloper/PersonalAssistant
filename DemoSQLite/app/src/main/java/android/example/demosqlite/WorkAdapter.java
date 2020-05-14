package android.example.demosqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class WorkAdapter extends ArrayAdapter {
    public Activity context;
    public List<String> workHour;
    public List<String> workTitle;
    public List<String> workDate;

    public WorkAdapter(Activity context, List<String> workHour, List<String> workTitle, List<String> workDate)
    {
        super(context, R.layout.work, workHour);
        this.context = context;
        this.workHour = workHour;
        this.workTitle = workTitle;
        this.workDate = workDate;
    }

    @Override
    public View getView(int position, View view, ViewGroup container)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.work, null, true);
        TextView title =(TextView)row.findViewById(R.id.titleWork);
        TextView hour = (TextView)row.findViewById(R.id.workHour);

        hour.setText(workHour.get(position));
        title.setText(workTitle.get(position));

        return row;
    }

}