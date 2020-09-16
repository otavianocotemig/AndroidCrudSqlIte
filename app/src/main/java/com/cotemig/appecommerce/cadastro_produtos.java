package com.cotemig.appecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.cotemig.appecommerce.Model.Produtos;
import com.cotemig.appecommerce.Model.ProdutosDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class cadastro_produtos extends AppCompatActivity  implements View.OnClickListener{

    // Instanciando a classe ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();

    private Produtos produto;
    private ProdutosDao produtosDao;

    // Para uso do ListView
    ArrayList<Produtos> listview_produtos;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);
        // Mapeando os objetos da tela
        this.mViewHolder.listview_Produtos = findViewById(R.id.Listview_Produtos);
        this.mViewHolder.btn_Cadastrar = findViewById(R.id.btn_Cadastrar);
        this.mViewHolder.btn_Cadastrar.setOnClickListener(this);
        CarregarProduto();


    }

    @Override
    protected  void onResume(){
        super.onResume();
        CarregarProduto();
    }
    @Override
    public void onClick(View v) {
        Intent telaproduto = new Intent(this,formulario_produtos.class);
        startActivity(telaproduto);
    }

    // Criar a classe viewHolder
    private static class ViewHolder{
        private ListView listview_Produtos;
        private FloatingActionButton btn_Cadastrar;


    }
    // Metodo para Carregar a Lista de Produtos
    public void CarregarProduto(){
        produtosDao = new ProdutosDao(this);
        listview_produtos = produtosDao.getLista();
        produtosDao.close();

        if (listview_produtos != null){
            adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listview_produtos);
            this.mViewHolder.listview_Produtos.setAdapter(adapter);
        }
    }
}