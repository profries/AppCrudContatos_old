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
    List<Contato> listaContatos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatos.add(new Contato("Adalberto","33445566"));
        listaContatos.add(new Contato("Beatriz","99995594"));
        listaContatos.add(new Contato("Carlos Eduardo","33441122"));

        ContatoAdapter adaptador = new ContatoAdapter(listaContatos,
                this);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String msg = listaContatos.get(position).getNome();
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }
        );



    }

    public void abrirFormulario(View v){
        Intent it = new Intent(this, CadastrarActivity.class);
        startActivity(it);
    }
}
