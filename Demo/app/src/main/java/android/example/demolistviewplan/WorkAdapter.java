package android.example.demolistviewplan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class WorkAdapter extends ArrayAdapter {
    public Activity context;
    public ArrayList<String> workHour;
    public ArrayList<String> workTitle;

    public WorkAdapter(Activity context, ArrayList<String> workHour, ArrayList<String> workTitle)
    {
        super(context, R.layout.work, workHour);
        this.context = context;
        this.workHour = workHour;
        this.workTitle = workTitle;
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
