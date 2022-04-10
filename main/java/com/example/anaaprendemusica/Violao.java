package com.example.anaaprendemusica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Violao extends AppCompatActivity {

    EditText edtNomeMusica;

    Button criar;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference contaoDatabaseReference = databaseReference.child("Musicas");
    long cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violao);

        edtNomeMusica = findViewById(R.id.editTextTextPersonName);
        criar = findViewById(R.id.button);

        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String musica = edtNomeMusica.getText().toString();
               Musicas m = new Musicas();
               m.setNome(musica);

                String idContato = Base64.encodeToString(m.getNome().getBytes(),Base64.DEFAULT);
                m.setId(idContato);
                Toast.makeText(getApplicationContext(), m.getId()+ "Vai Tomar no CÙ" + idContato, Toast.LENGTH_SHORT).show();
                contaoDatabaseReference.child("10").setValue(m.getNome());
            }
        });


    }

    private void cadastrarMusica(Musicas m){
        contaoDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                String idContato = Base64.encodeToString(m.getNome().getBytes(),Base64.DEFAULT);
                m.setId(idContato);

                boolean contatoJaCadastrado = snapshot.hasChild(idContato);

                if(contatoJaCadastrado){

                }
                else{
                    contaoDatabaseReference.child(idContato).setValue(m);
                    Toast.makeText(getApplicationContext(),"Vai Tomar no CÙ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}