package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_chat_activity extends Fragment {
    public Fragment_chat_activity() {
    }
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View rootview = inflater.inflate(R.layout.fragment_chat,container,false);
         textView = (TextView) rootview.findViewById(R.id.chattxt);
         textView.setText("CHAT");
         return rootview;

    }
}
