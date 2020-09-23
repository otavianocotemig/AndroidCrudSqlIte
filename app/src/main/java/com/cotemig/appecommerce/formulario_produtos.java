package com.cotemig.appecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cotemig.appecommerce.Model.Produtos;
import com.cotemig.appecommerce.Model.ProdutosDao;

public class formulario_produtos extends AppCompatActivity implements  View.OnClickListener {

    private ViewHolder mviewHolder = new ViewHolder();
    // Atributos para instanciar as classes de CRUD
    private Produtos produto, EditarProduto;
    private ProdutosDao produtodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produtos);

        // Criar os objetos que serão utilizados
        produto = new Produtos();
        produtodao = new ProdutosDao(this);
        //
        Intent intent = getIntent();
        EditarProduto = (Produtos) intent.getSerializableExtra("produto-escolhido");


        // Mapeamento dos objetos da tela
        this.mviewHolder.editText_NomeProd  = findViewById(R.id.editText_NomeProd);
        this.mviewHolder.editText_Descricao  = findViewById(R.id.editText_Descricao);
        this.mviewHolder.editText_Quantidade  = findViewById(R.id.editText_Quantidade);
        this.mviewHolder.editText_Preco  = findViewById(R.id.editText_Preco);
        this.mviewHolder.btn_Produto  = findViewById(R.id.btn_Produto);

        this.mviewHolder.btn_Produto.setOnClickListener(this);

        // Verificar se tem informação no EditarProduto
        if (EditarProduto != null){
            this.mviewHolder.btn_Produto.setText("Modificar Produto");
            this.mviewHolder.editText_NomeProd.setText(EditarProduto.getNomeProduto());
            this.mviewHolder.editText_Descricao.setText(EditarProduto.getDescricao());
            this.mviewHolder.editText_Preco.setText(EditarProduto.getPreco()+"");
            this.mviewHolder.editText_Quantidade.setText(EditarProduto.getQuantidade()+"");
            produto.setId(EditarProduto.getId());
        }else{
            this.mviewHolder.btn_Produto.setText("Cadastrar Produto");
        }


    }

    @Override
    public void onClick(View v) {
        // Incluindo dados na tabela de produtos
        produto.setNomeProduto(this.mviewHolder.editText_NomeProd.getText().toString());
        produto.setDescricao(this.mviewHolder.editText_Descricao.getText().toString());
        produto.setPreco(Double.parseDouble(this.mviewHolder.editText_Preco.getText().toString()));
        produto.setQuantidade(Integer.parseInt(this.mviewHolder.editText_Quantidade.getText().toString()));
        // Chamar a classe para inserir o produto
        if (this.mviewHolder.btn_Produto.getText().toString().equals("Cadastrar Produto")){
            produtodao.salvarProduto(produto);
            Utilidades.Alert(this,"Produto Inserido com Sucesso.");
        }else{
            produtodao.alterarProduto(produto);
            Utilidades.Alert(this,"Produto Alterado com Sucesso.");
        }

        produtodao.close();


    }

    private static class ViewHolder{
        private EditText editText_NomeProd;
        private EditText editText_Descricao;
        private EditText editText_Quantidade;
        private EditText editText_Preco;
        private Button btn_Produto;
    }
}