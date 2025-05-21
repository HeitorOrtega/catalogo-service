package br.com.fiap.pedidoservice.repository;

import br.com.fiap.pedidoservice.model.Pedido;

public interface PedidoRepository {
    public Pedido findById(int id);
}
