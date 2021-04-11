package com.example.work_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Resume extends AppCompatActivity {

    EditText inputWork, inputDataMe, inputDataLanguages;
    Button create;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);


        inputWork = findViewById(R.id.inputWork);
        inputDataMe = findViewById(R.id.inputDataMe);
        inputDataLanguages = findViewById(R.id.inputDataLanguages);

        final Intent windowMainActivity = new Intent(com.example.work_app.Resume.this, MainActivity.class);

        create = findViewById(R.id.Create);
        View.OnClickListener onCreate = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(windowMainActivity);
            }
        };
        create.setOnClickListener(onCreate);

        back = findViewById(R.id.buttonBack);
        View.OnClickListener onClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.work_app.Resume.this, MainActivity.class);
                startActivity(intent);
            }
        };

        back.setOnClickListener(onClickListener);
    }
}