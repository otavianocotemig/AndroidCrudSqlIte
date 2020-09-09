package com.cotemig.appecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    // Instanciar a classe ViewHolder
    private ViewHolder mviewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // identificar e definir os componentes que serão manipulados da activity
        this.mviewHolder.iv_product_detail = this.findViewById(R.id.iv_product_detail);
        this.mviewHolder.iv_product_detail.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        // chamda da tela de details products
        Intent acessoTelaDetailsProducts = new Intent(this,product_detailsActivity.class);
        startActivity(acessoTelaDetailsProducts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprincipal,menu);
       return super.onCreateOptionsMenu(menu);
    }

    // metodo do APP que executa o que foi selecionado no menu de opções
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_cadastroProduto){
            Intent acessoTelaCadProdutos = new Intent(this,cadastro_produtos.class);
            startActivity(acessoTelaCadProdutos);
        }
        return super.onOptionsItemSelected(item);
    }


    private static class ViewHolder{
        private ImageView iv_product_detail;
    }
}
