package br.com.fiap.pedidoservice.controller;

import br.com.fiap.pedidoservice.model.Pedido;
import br.com.fiap.pedidoservice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PedidoController {

    @RestController
    @RequestMapping("/api/pedidos")
    public class PedidosController {
        private final PedidoService pedidoService;
        @Autowired
        public PedidoController(PedidoService pedidoService){
            this.pedidoService = pedidoService;
        }

    }

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = PedidoService.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}
