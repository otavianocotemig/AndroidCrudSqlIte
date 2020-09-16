package com.cotemig.appecommerce.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ProdutosDao extends SQLiteOpenHelper {
    private static final String DATABASE = "LOJAVIRTUAL3B11";
    private static final int VERSION = 1;

    // Metodo Construtor da classe
    public ProdutosDao (Context context){
        super(context,DATABASE,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Produto = "CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nomeProduto TEXT NOT NULL, Descricao TEXT NOT NULL, Quantidade INTEGER, Preco Double);";
        db.execSQL(Produto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Produto = "DROP TABLE IF EXISTS produtos";
        db.execSQL(Produto);
    }
    // Metodo para Salvar Produto
    public void salvarProduto(Produtos produto){
        // Criando um array na memória para armazenar os dados para insert
        ContentValues registro = new ContentValues();
        registro.put("NomeProduto",produto.getNomeProduto());
        registro.put("Descricao",produto.getDescricao());
        registro.put("Quantidade",produto.getQuantidade());
        registro.put("Preco",produto.getPreco());
        // Grava os dados no banco
        getWritableDatabase().insert("produtos",null,registro);
      }
      // Método para Alterar
    public void alterarProduto(Produtos produto){

        ContentValues registro = new ContentValues();
        registro.put("NomeProduto",produto.getNomeProduto());
        registro.put("Descricao",produto.getDescricao());
        registro.put("Quantidade",produto.getQuantidade());
        registro.put("Preco",produto.getPreco());
        // pega o parametro do id para alterar o produto
        String [] args = {produto.getId().toString()};
        getWritableDatabase().update("produtos",registro,"id=?",args);

    }
    // Metodo para Excluir
    public void deletarProduto(Produtos produto){
        // pega o parametro do id para alterar o produto
        String [] args = {produto.getId().toString()};
        getWritableDatabase().delete("produtos","id=?",args);
    }
    // Metodo para Selecionar Registros
    public ArrayList<Produtos> getLista(){
        // Monta a string que irá retornar os dados da consulta
        String [] colunas = {"id","NomeProduto","Descricao","Quantidade","Preco"};
        Cursor query = getWritableDatabase().query("produtos",colunas,null,null,null,null,null,null);
        ArrayList<Produtos> produtos = new ArrayList<>();

        while (query.moveToNext()){
            Produtos produto = new Produtos();
            produto.setId(query.getLong(0));
            produto.setNomeProduto(query.getString(1));
            produto.setDescricao(query.getString(2));
            produto.setQuantidade(query.getInt(3));
            produto.setPreco(query.getDouble(4));

            produtos.add(produto);
        }
        return produtos;
    }

}
