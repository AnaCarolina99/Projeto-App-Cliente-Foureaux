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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Base64;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    Button botaoCdastro;
    Button botaoLogin;

    EditText edtEmail;
    EditText edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.editTextTextEmailAddress);
        edtSenha = findViewById(R.id.editTextTextPassword);
        botaoLogin= findViewById(R.id.botaoLogin);
        botaoCdastro = findViewById(R.id.btn_cadastro);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = edtEmail.getText().toString();
                String loginSenha = edtSenha.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)){
                    mAuth.signInWithEmailAndPassword(loginEmail,loginSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                abrirTelaPrincipal();
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

        botaoCdastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , Cadastro.class));
            }
        });



    }

    public void abrirTelaPrincipal(){
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
        finish();
    }



}