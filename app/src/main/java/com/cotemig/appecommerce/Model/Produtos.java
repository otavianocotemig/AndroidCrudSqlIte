package com.cotemig.appecommerce.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Produtos implements Serializable {
    private Long id;
    private String nomeProduto;
    private String Descricao;
    private int Quantidade;
    private double Preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

        @Override
    public String toString() {
        return nomeProduto.toString() +" - "+Descricao.toString();
    }
}
