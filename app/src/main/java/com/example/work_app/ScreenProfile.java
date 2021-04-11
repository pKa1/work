package com.example.work_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ScreenProfile extends Fragment {

    final static public String TAG_SP = "ScreenProfileTag";

    Context context;
    Button addResume;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_screen_profile, container, false);
        context = container.getContext();

        addResume = view.findViewById(R.id.createResume);
        View.OnClickListener onAddResume = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent windowResume = new Intent(getActivity(), Resume.class);
                startActivity(windowResume);
            }
        };
        addResume.setOnClickListener(onAddResume);
        return view;
    }
}