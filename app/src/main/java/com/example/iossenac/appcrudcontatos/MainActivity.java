package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_CADASTRO=1;
    private static final int REQ_DETALHE=2;

    List<Contato> listaContatos = new ArrayList<>();
    ContatoAdapter adaptador;
    int posicaoAlterar=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatos.add(new Contato("Adalberto","33445566"));
        listaContatos.add(new Contato("Beatriz","99995594"));
        listaContatos.add(new Contato("Carlos Eduardo","33441122"));

        adaptador = new ContatoAdapter(listaContatos,
                this);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Contato contato = listaContatos.get(position);
                        MainActivity.this.posicaoAlterar = position;

                        Intent it = new Intent(MainActivity.this, DetalheActivity.class);
                        it.putExtra("contato",contato);
                        startActivityForResult(it,REQ_DETALHE);
                    }
                }
        );



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CADASTRO)
        {
            if(resultCode == RESULT_OK){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaContatos.add(contato);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this,"Cadastro realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
        }
        else if(requestCode == REQ_DETALHE){
            if(resultCode == DetalheActivity.RESULT_EDIT){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaContatos.set(this.posicaoAlterar,
                        contato);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this,"Edicao realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
            else if(resultCode == DetalheActivity.RESULT_DELETE){
                listaContatos.remove(this.posicaoAlterar);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this,"Exclusao realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    public void abrirFormulario(View v){
        Intent it = new Intent(MainActivity.this, CadastrarActivity.class);
        startActivityForResult(it,REQ_CADASTRO);

    }

    public void finalizar(View view){
        finish();
    }
}
