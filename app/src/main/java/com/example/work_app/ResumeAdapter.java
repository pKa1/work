package com.example.work_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ResumeAdapter extends BaseAdapter {

    List<com.example.work_app.ResumeView> list;
    LayoutInflater layoutInflater;


    public ResumeAdapter(Context context, List<com.example.work_app.ResumeView> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_vacansion, parent, false);
        }

        com.example.work_app.ResumeView resumeView = getResumeView(position);

        TextView work = view.findViewById(R.id.work);
        TextView me = view.findViewById(R.id.me);
        TextView languages = view.findViewById(R.id.languages);

        work.setText(resumeView.getWork());
        me.setText(resumeView.getMe());
        languages.setText(resumeView.getLanguages());
        return view;
    }

    public com.example.work_app.ResumeView getResumeView(int position) {
        return (com.example.work_app.ResumeView)getResumeView(position);
    }
}
