package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

    }

    public void cadastrar(View v){
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        EditText editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        Contato contato = new Contato(editTextNome.getText().toString(),
                editTextTelefone.getText().toString());
        Intent data = new Intent();
        data.putExtra("contato",contato);
        setResult(RESULT_OK,data);
        finish();

    }

    public void cancelar(View view){
        finish();
    }
}
