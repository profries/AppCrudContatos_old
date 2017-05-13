package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Intent it = this.getIntent();
        //String nome = it.getStringExtra("nome");
        //String telefone = it.getStringExtra("telefone");
        Contato contato = (Contato) it.getSerializableExtra("contato");

        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextNome.setText(contato.getNome());

        EditText editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextTelefone.setText(contato.getTelefone());
    }


    public void cancelar(View view){
        finish();
    }
}
