package com.example.work_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class ScreenVacansion extends Fragment implements View.OnClickListener{

    final static public String TAG_FV = "FragmenVacansionTag";

    Context context;
    ListView listVacansion;
    com.example.work_app.VacansionAdapter vacansionAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmen_vacansion, container, false);
        context = container.getContext();

        listVacansion = (ListView)view.findViewById(R.id.listVacansino);
        vacansionAdapter = new com.example.work_app.VacansionAdapter(context, initData());
        listVacansion.setAdapter(vacansionAdapter);

        return view;
    }

    

    private List<Vacansion> initData()
    {
        List<Vacansion> list = new ArrayList<Vacansion>();

        list.add(new Vacansion("Тюмень", "Java разработчик", "70 000 - 90 000",
                "\"Разработка ПО. Участие в составлении архитектуры программного обеспечения. Рефакторинг программного кода. Оптимизация ПО. Поддержка разрабатываемых программных продуктов.\n" +
                        "Уверенное владение основными технологиями Java и понимание принципов объектно-ориентированного программирования. Опыт разработки на платформе Java EE (JSP/Servlets, Spring).\"", false));
        list.add(new Vacansion("Тюмень", "Junior C# разработчик (full-stack / back-end)", "80 000 - 120 000",
                "60 человек в разработке, 8 команд. Комнаты по 8-10 человек. Десктоп i9 с SSD или MacBook Pro, 2...\n" +
                        "Ищем C# разработчика стремящегося научиться делать софт для бизнеса и через два года стать сеньером. Нужно любить писать код и...\n", false));
        list.add(new Vacansion("Тюмень", "Fullstack стажер-разработчик (C#, React, MSSQL)",
                "25 000 - 25 000", "Работу над сложным продуктом в кросс-функциональной команде.\n" +
                "Требуется практический опыт использования C# и SQL: личные или студенческие веб-приложения, работающие с базой данных. Теоретическая подготовка в виде...\n", false));
        return  list;
    }

    @Override
    public void onClick(View v) {
        listVacansion.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //Intent windowVacansionView = new Intent(context, VacansionView.class );
                //startActivity(windowVacansionView);
                Intent intent = new Intent();
                intent.setClass(context, com.example.work_app.VacansionView.class);
                startActivity(intent);
            }
        });
    }
}