package com.example.work_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class VacansionAdapter extends BaseAdapter {

    private List<Vacansion> list;
    private LayoutInflater layoutInflater;
    boolean checkFavorite = false;

    public VacansionAdapter(Context context, List<Vacansion> listVacansion) {
        this.list = listVacansion;
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

        //Назначение view начало
        TextView title = view.findViewById(R.id.textTitle);
        TextView city = view.findViewById(R.id.textCity);
        TextView salary = view.findViewById(R.id.salary);
        TextView briefDescription = view.findViewById(R.id.briefDescription);
        //Назначение view конец

        Vacansion vacansion = getVacansion(position);

        title.setText(vacansion.getTitle());
        city.setText(vacansion.getCity());
        salary.setText(vacansion.getSalary());
        briefDescription.setText(vacansion.getBriefDescription());
        ImageButton favorite = (ImageButton)view.findViewById(R.id.favorite);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFavorite == false){
                    favorite.setImageResource(R.drawable.ic_star_rate);
                    checkFavorite = true;
                }
                else{
                 favorite.setImageResource(R.drawable.ic_star_border_black_24dp);
                 checkFavorite = false;
                }
            }
        };
        favorite.setOnClickListener(onClickListener);

        return view;
    }

    private Vacansion getVacansion(int position){
        return (Vacansion) getItem(position);
    }

}
