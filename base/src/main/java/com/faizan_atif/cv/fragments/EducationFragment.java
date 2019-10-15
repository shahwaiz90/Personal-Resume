package com.faizan_atif.cv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faizan_atif.cv.adapters.EducationAdapter;
import com.faizan_atif.cv.base.R;
import com.faizan_atif.cv.model.EducationModel;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {

    public EducationFragment() {
        // Required empty public constructor
    }
    public static EducationFragment newInstance() {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        RecyclerView recyclerViewDemo = view.findViewById(R.id.recyclerViewDemo1);
        recyclerViewDemo.setLayoutManager(new LinearLayoutManager(getContext()));

//        RecyclerView recyclerViewDemo2 = view.findViewById(R.id.recyclerViewDemo2);
//        recyclerViewDemo2.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewDemo.setAdapter(new EducationAdapter(feedItems(), getContext()));
//        recyclerViewDemo2.setAdapter(new EducationAdapter(feedItems2(), getContext()));

        return view;
    }
    private List<EducationModel> feedItems() {
//        String Titles = "Education Section" ;
        List<EducationModel> demoItems = new ArrayList<>();
        demoItems.add(new EducationModel("Bachelor of Computer Science(BSCS)","National University of Computer and Emerging Sciences", "(2017 - 2021)", R.drawable.fastlogo));
        demoItems.add(new EducationModel("F.Sc. Pre-Engineering","Punjab Group of Colleges", "(2015 - 2017)", R.drawable.pgc_logo));
        demoItems.add(new EducationModel("Matriculation","St. Anthony High School", "(2015)", R.drawable.school_logo));

//        DemoItem demoItem = new DemoItem(Titles);
//        demoItems.add(demoItem);
        return demoItems;

    }
//    private List<EducationModel> feedItems2() {
//        List<EducationModel> demoItems = new ArrayList<>();
//        demoItems.add(new EducationModel("IEEE","EE dept", " - 2019", R.drawable.linkedin));
//        demoItems.add(new EducationModel("Softec","Global", " - 2020", R.drawable.github));
//        return demoItems;
//    }
}




