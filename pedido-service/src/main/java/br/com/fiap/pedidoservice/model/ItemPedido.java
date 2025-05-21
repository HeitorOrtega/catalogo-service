package br.com.fiap.pedidoservice.model;

import jakarta.persistence.Entity;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idProduto;
    private int quantidade;
    private int PrecoUnitario;

    public int getPrecoUnitario() {
        return PrecoUnitario;
    }

    public void setPrecoUnitario(int precoUnitario) {
        PrecoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}