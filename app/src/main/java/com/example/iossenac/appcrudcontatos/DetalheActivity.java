package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalheActivity extends AppCompatActivity {
    public static final int RESULT_EDIT=1;
    public static final int RESULT_DELETE=2;
    EditText editTextNome, editTextTelefone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent it = getIntent();
        Contato contatoEditar = (Contato) it.getSerializableExtra("contato");

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextNome.setText(contatoEditar.getNome());
        editTextTelefone.setText(contatoEditar.getTelefone());
    }


    public void editar(View v){
        Contato contato = new Contato(editTextNome.getText().toString(),
                editTextTelefone.getText().toString());
        Intent data = new Intent();
        data.putExtra("contato",contato);
        setResult(RESULT_EDIT,data);
        finish();
    }

    public void excluir(View v){
        setResult(RESULT_DELETE);
        finish();
    }

    public void voltar(View v){
        finish();
    }
}
