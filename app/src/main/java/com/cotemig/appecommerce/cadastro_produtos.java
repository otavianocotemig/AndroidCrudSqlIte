package com.cotemig.appecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class cadastro_produtos extends AppCompatActivity  implements View.OnClickListener{

    // Instanciando a classe ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);
        // Mapeando os objetos da tela
        this.mViewHolder.Listview_Produtos = findViewById(R.id.Listview_Produtos);
        this.mViewHolder.btn_Cadastrar = findViewById(R.id.btn_Cadastrar);
        this.mViewHolder.btn_Cadastrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent telaproduto = new Intent(this,formulario_produtos.class);
        startActivity(telaproduto);
    }

    // Criar a classe viewHolder
    private static class ViewHolder{
        private ListView Listview_Produtos;
        private FloatingActionButton btn_Cadastrar;


    }
}