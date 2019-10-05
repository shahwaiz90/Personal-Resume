package com.ahmad.cv.fragments;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmad.cv.model.DemoItem;
import com.ahmad.cv.adapters.EducationAdapter;
import com.ahmad.cv.base.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
       recyclerViewDemo.setAdapter(new EducationAdapter(feedItems(), getContext()));
        return view;
    }
    private List<DemoItem> feedItems() {
        String Titles = "Education Section" ;
        List<DemoItem> demoItems = new ArrayList<>();
        DemoItem demoItem = new DemoItem(Titles);
        demoItems.add(demoItem);
        return demoItems;

    }
}




