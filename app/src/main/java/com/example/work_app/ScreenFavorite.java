package com.example.work_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ScreenFavorite extends Fragment {

    final static public String TAG_SF = "ScreenFavoriteTag";

    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_favorite, container, false);

        context = container.getContext();



        return  view;
    }
}