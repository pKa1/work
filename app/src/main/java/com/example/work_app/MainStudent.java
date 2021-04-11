package com.example.work_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainStudent extends AppCompatActivity implements View.OnClickListener
{
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private EditText EmailAddress;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);

        mAuth = FirebaseAuth.getInstance();

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

        EmailAddress = (EditText) findViewById(R.id.TextEmailAddress);
        Password = (EditText) findViewById(R.id.TextTextPassword);

        findViewById(R.id.button4).setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.button4)
        {
            registration(EmailAddress.getText().toString(),Password.getText().toString());
        }
    }

    public void registration (String email , String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainStudent.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    Act();
                    Int();
                }
                else
                    Toast.makeText(MainStudent.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Act()
    {
        Intent intent51 = new Intent(this,MainStydMain.class);
        startActivity(intent51);
    }

    public void Int()
    {

        EditText pass = (EditText)findViewById(R.id.TextTextPassword);

        EditText name = (EditText)findViewById(R.id.PersonName);
        EditText name2 = (EditText)findViewById(R.id.PersonName2);
        EditText name3 = (EditText)findViewById(R.id.PersonName3);

        if( pass.getText().length()>=6 && name.getText().length()>=2 &&
                name2.getText().length()>=2 && name3.getText().length()>=2 && Eemail() == true){

        }
    }

    public boolean Eemail()
    {
        EditText emailAddress =(EditText)findViewById(R.id.TextEmailAddress);

        String validemail= "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

        String emal = emailAddress.getText().toString();

        String k = emal , e9 = "@";

        Matcher mat = Pattern.compile(validemail).matcher(emal);

        if (mat.matches() && k.indexOf(e9)>2);
        return mat.matches();
    }
}