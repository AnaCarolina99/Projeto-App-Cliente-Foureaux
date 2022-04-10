package com.example.anaaprendemusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button botaoViolao = findViewById(R.id.btn_Violao);
        botaoViolao.setOnClickListener( new View.OnClickListener() {
                                             public void onClick(View v){
                                                 startActivity(new Intent(Home.this , Violao.class));
                                             }
                                         }
        );

        Button botaoViola = findViewById(R.id.btn_Viola);
        botaoViola.setOnClickListener( new View.OnClickListener() {
                                            public void onClick(View v){
                                                startActivity(new Intent(Home.this , Viola.class));
                                            }
                                        }
        );

        Button botaoBaixo = findViewById(R.id.btn_Baixo);
        botaoBaixo.setOnClickListener( new View.OnClickListener() {
                                            public void onClick(View v){
                                                startActivity(new Intent(Home.this , Baixo.class));
                                            }
                                        }
        );
    }

}