package com.example.anaaprendemusica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Cadastro extends AppCompatActivity {

    private FirebaseAuth mAuth;


    EditText edtEmail;
    EditText edtSenha;

    Button cadastro;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mAuth = FirebaseAuth.getInstance();

        edtEmail = findViewById(R.id.editTextTextEmailAddress2);
        edtSenha = findViewById(R.id.editTextTextPassword2);

        cadastro = findViewById(R.id.btn_cadastro3);
        login = findViewById(R.id.button2);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = edtEmail.getText().toString();
                String loginSenha = edtSenha.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)){
                    mAuth.createUserWithEmailAndPassword(loginEmail,loginSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                abrirTelaPrincipal();
                                Toast.makeText(getApplicationContext(),"Sucesso",Toast.LENGTH_SHORT).show();
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void abrirTelaPrincipal(){
        Intent intent = new Intent(Cadastro.this, Home.class);
        startActivity(intent);
        finish();
    }


}