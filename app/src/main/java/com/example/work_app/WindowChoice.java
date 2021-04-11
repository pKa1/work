package com.example.work_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WindowChoice extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_choice);
    }
    public void Employer(View v)
    {
        Intent intent2 = new Intent(this, MainEmployer.class);
        startActivity(intent2);
    }

    public void Student(View v)
    {
        Intent intent99 = new Intent(this, MainStudent.class);
        startActivity(intent99);
    }

}