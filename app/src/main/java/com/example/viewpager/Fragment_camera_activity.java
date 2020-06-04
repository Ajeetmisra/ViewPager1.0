package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_camera_activity extends Fragment {
    public Fragment_camera_activity() {
    }
    TextView textView;
    private DataAdapter dataAdapter;
    private MyViewModel myViewModel;
    ArrayList<States> info;
    ArrayList<States> info2;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View rootview = inflater.inflate(R.layout.fragment_camera,container,false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.RecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

         return rootview;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    // onViewCreated make sure that your view has fully created or not
    // we can implement view model pattern in oncreateview but it crashes because sometimes
    // the view is not properly created
    // so its good to have view model in oncreatedview
        @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        myViewModel.getStates().observe(getViewLifecycleOwner(), new Observer<List<States>>() {
            @Override
            public void onChanged(List<States> states) {
                // update UI
                dataAdapter = new DataAdapter((ArrayList<States>) states);

                recyclerView.setAdapter(dataAdapter);

            }
        });
    }


}
