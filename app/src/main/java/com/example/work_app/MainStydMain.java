package com.example.work_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainStydMain extends AppCompatActivity
{

    //Фрагменты начало
    ScreenVacansion screenVacansion;
    ScreenFavorite screenFavorite;
    ScreenMessage screenMessage;
    ScreenProfile screenProfile;
    //Фрагменты конец

    FragmentManager manager;
    FragmentTransaction transaction;

    BottomNavigationView bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_styd_main);


        //Объявление фрагментов начало
        screenVacansion = new ScreenVacansion();
        screenFavorite = new ScreenFavorite();
        screenMessage = new ScreenMessage();
        screenProfile = new ScreenProfile();
        //Объявление фрагментов конец

        //Добавление фрагмента Вакансии на экран начало
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.containerForFragment, screenVacansion, ScreenVacansion.TAG_FV);
        transaction.commit();
        //Добавление фрагмента Вакансии на экран конец

        //BottomViewNavigation начало
        bottomMenu = findViewById(R.id.bottomMenu);
        bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                transaction = manager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.action_vacation:
                        if (manager.findFragmentByTag(screenVacansion.TAG_FV) == null) {
                            transaction.remove(screenFavorite);
                            transaction.remove(screenProfile);
                            transaction.remove(screenMessage);
                            transaction.add(R.id.containerForFragment, screenVacansion, ScreenVacansion.TAG_FV);
                        }
                        break;
                    case R.id.action_favorite:
                        if (manager.findFragmentByTag(screenFavorite.TAG_SF) == null) {
                            transaction.remove(screenVacansion);
                            transaction.remove(screenProfile);
                            transaction.remove(screenMessage);
                            transaction.add(R.id.containerForFragment, screenFavorite, ScreenFavorite.TAG_SF);
                        }
                        break;
                    case R.id.action_message:
                        if (manager.findFragmentByTag(screenMessage.TAG_SM) == null) {
                            transaction.remove(screenVacansion);
                            transaction.remove(screenProfile);
                            transaction.remove(screenFavorite);
                            transaction.add(R.id.containerForFragment, screenMessage, ScreenMessage.TAG_SM);
                        }
                        break;
                    case R.id.action_profile:
                        if (manager.findFragmentByTag(screenProfile.TAG_SP) == null) {
                            transaction.remove(screenFavorite);
                            transaction.remove(screenVacansion);
                            transaction.remove(screenMessage);
                            transaction.add(R.id.containerForFragment, screenProfile, ScreenProfile.TAG_SP);
                        }
                        break;
                }
                transaction.commit();
                return true;
            }
        });
        //BottomViewNavigation конец
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}