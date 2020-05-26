package android.example.demolistviewplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewWorks extends RecyclerView.Adapter<RecyclerViewWorks.WorksViewsHolder> {
    private List<Work> works;
    private Context context;

    public RecyclerViewWorks(Context context, List<Work> works)
    {
        this.context = context;
        this.works = works;
    }


    @NonNull
    @Override
    public WorksViewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.work, parent, false);
        return new WorksViewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewWorks.WorksViewsHolder holder, int position) {
        String stringTitle = works.get(position).getTitle();
        String stringTime = works.get(position).getTime();
        String stringLocation = works.get(position).getLocation();

        holder.txtTitle.setText(stringTitle);
        holder.txtTime.setText(stringTime);
        holder.txtLocation.setText(stringLocation);

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        holder.work_layout.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return works==null?0:works.size();
    }


    public static class WorksViewsHolder extends RecyclerView.ViewHolder {

        private LinearLayout work_layout;
        private TextView txtTitle;
        private TextView txtTime;
        private TextView txtLocation;

        public WorksViewsHolder(@NonNull View itemView) {
            super(itemView);
            work_layout = (LinearLayout)itemView.findViewById(R.id.work_layout);
            txtTitle = (TextView)itemView.findViewById(R.id.titleWork);
            txtTime = (TextView)itemView.findViewById(R.id.workHour);
            txtLocation = (TextView) itemView.findViewById(R.id.location);
        }
    }
}
