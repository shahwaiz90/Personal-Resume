package com.ahmad.cv.fragments;
import android.os.Bundle;

import com.ahmad.cv.model.DemoItem;
import com.ahmad.cv.adapters.ProfessionAdapter;
import com.ahmad.cv.base.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessionFragment extends Fragment {

    public ProfessionFragment() {
        // Required empty public constructor
    }
    public static ProfessionFragment newInstance() {
        ProfessionFragment fragment = new ProfessionFragment();
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
        View view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        RecyclerView recyclerViewDemo = view.findViewById(R.id.recyclerViewDemo3);
        recyclerViewDemo.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDemo.setAdapter(new ProfessionAdapter(feedItems(), getContext()));
        return view;
    }

    private List<DemoItem> feedItems() {
        String Titles = "Profession Section";
        List<DemoItem> demoItems = new ArrayList<>();
        DemoItem demoItem = new DemoItem(Titles);
        demoItems.add(demoItem);
        return demoItems;

    }
}
