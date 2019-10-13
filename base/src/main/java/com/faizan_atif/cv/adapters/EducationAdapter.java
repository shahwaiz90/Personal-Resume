package com.faizan_atif.cv.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faizan_atif.cv.model.DemoItem;
import com.faizan_atif.cv.base.R;
import com.faizan_atif.cv.model.EducationModel;

import java.util.List;
public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.DemoItemHolder> {
    private List<EducationModel> educationModelList;
    private Context context;
    private ImageView education_publication_link;

    public EducationAdapter(List<EducationModel> educationModelList, Context context) {
        this.educationModelList = educationModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public DemoItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.education, parent, false);

        return new DemoItemHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull DemoItemHolder holder, int position) {
        //DisplayMetrics displayMetrics = new DisplayMetrics();
//        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);


        holder.mLogo.setImageResource(educationModelList.get(position).instituteLogo);
        holder.mInstituteYear.setText(educationModelList.get(position).year);
        holder.mDegreeTitle.setText(educationModelList.get(position).degreeRank);
        holder.mInstituteName.setText(educationModelList.get(position).universityName);
    }

    @Override
    public int getItemCount() {
        return educationModelList.size();
    }

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View row = inflater.inflate(R.layout.education, parent, false);
//        education_publication_link  = row.findViewById(R.id.education_publication_link);
//        education_publication_link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.ieee_link)));
//                    context.startActivity(intent);
//                }
//        });
//        return new DemoItemHolder(row);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//    }
//
//    @Override
//    public int getItemCount() {
//        return demoItems.size();
//    }

    public class DemoItemHolder extends RecyclerView.ViewHolder {
        public ImageView mLogo;
        public TextView mDegreeTitle;
        public TextView mInstituteName;
        public TextView mInstituteYear;
        DemoItemHolder(View itemView) {
            super(itemView);
            mDegreeTitle = itemView.findViewById(R.id.degreeTitle);
            mInstituteName= itemView.findViewById(R.id.instituteName);
            mInstituteYear = itemView.findViewById(R.id.instituteyear);
            mLogo = itemView.findViewById(R.id.education_publication_link);

        }
    }
}
