package com.hamza1999.cv.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hamza1999.cv.base.R;
import com.hamza1999.cv.model.Skill;

import java.util.List;
public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.DemoItemHolder2> {
    private List<Skill> items;
    private Context        context;
    public ProfessionAdapter(List<Skill> items, Context context) {
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public DemoItemHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.skill_row, parent, false);
        return new DemoItemHolder2(row);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoItemHolder2 holder, int position) {
        holder.rating.setRating(items.get(position).getRating());
        holder.skill.setText(items.get(position).getSkill());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class DemoItemHolder2 extends RecyclerView.ViewHolder {
        TextView skill;
        RatingBar rating;
        DemoItemHolder2(View itemView) {
            super(itemView);
            skill = itemView.findViewById(R.id.skill_name);
            rating = itemView.findViewById(R.id.rating);
        }
    }

}
