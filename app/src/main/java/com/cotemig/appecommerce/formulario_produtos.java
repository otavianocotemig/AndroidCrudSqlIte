package com.cotemig.appecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cotemig.appecommerce.Model.Produtos;
import com.cotemig.appecommerce.Model.ProdutosDao;

public class formulario_produtos extends AppCompatActivity implements  View.OnClickListener {

    private ViewHolder mviewHolder = new ViewHolder();
    private Produtos produto;
    private ProdutosDao produtodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produtos);

        // Criar os objetos que serão utilizados
        produto = new Produtos();
        produtodao = new ProdutosDao(this);
        //
        // Mapeamento dos objetos da tela
        this.mviewHolder.editText_NomeProd  = findViewById(R.id.editText_NomeProd);
        this.mviewHolder.editText_Descricao  = findViewById(R.id.editText_Descricao);
        this.mviewHolder.editText_Quantidade  = findViewById(R.id.editText_Quantidade);
        this.mviewHolder.editText_Preco  = findViewById(R.id.editText_Preco);
        this.mviewHolder.btn_Produto  = findViewById(R.id.btn_Produto);

        this.mviewHolder.btn_Produto.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Incluir Registro no banco
        produto.setNomeProduto(this.mviewHolder.editText_NomeProd.toString());
        produto.setDescricao(this.mviewHolder.editText_Descricao.toString());
        produtodao.salvarProduto(produto);


    }

    private static class ViewHolder{
        private EditText editText_NomeProd;
        private EditText editText_Descricao;
        private EditText editText_Quantidade;
        private EditText editText_Preco;
        private Button btn_Produto;
    }
}