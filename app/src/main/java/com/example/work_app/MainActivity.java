package com.example.work_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Toolbar toolbar;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText EmailAddress;
    private EditText Password;


    //EditText  Email = (EditText)findViewById(R.id.EmailAddress);
    //EditText  Pass = (EditText)findViewById(R.id.Password);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        TextView aut = (TextView)findViewById(R.id.textView2);
        String htmlTaggedString  = "<u>Зарегистрироваться</u>";
        Spanned textSpan  =  android.text.Html.fromHtml(htmlTaggedString);
        aut.setText(textSpan);


        mAuthListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {
                    // User is signed in

                } else
                    {
                    // User is signed out

                }
            }
        };

        EmailAddress = (EditText) findViewById(R.id.emailAddress);
        Password = (EditText) findViewById(R.id.password);

        findViewById(R.id.Aut).setOnClickListener(this);
        //findViewById(R.id.textView2).setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.Aut)
        {
            signin(EmailAddress.getText().toString(),Password.getText().toString());
        }
    }

    public void signin(String email , String password)
    {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Aвторизация успешна", Toast.LENGTH_SHORT).show();
                    Styd();

                }else
                    Toast.makeText(MainActivity.this, "Aвторизация провалена", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void Styd(){
        Intent intent8 = new Intent(this, MainStydMain.class);
        startActivity(intent8);
    }
    public void Robota1(){
        Intent intent9 = new Intent(this, MainStydMain.class);
        startActivity(intent9);

    }
    public void check(View v)
    {
        Intent intent = new Intent(this, WindowChoice.class);
        startActivity(intent);
    }


}