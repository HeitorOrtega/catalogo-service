package br.com.fiap.pedidoservice.service;

import br.com.fiap.pedidoservice.DTO.ProdutoDTO;
import br.com.fiap.pedidoservice.model.ItemPedido;
import br.com.fiap.pedidoservice.repository.PedidoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class PedidoService {

    public static final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final RestTemplate restTemplate;

    @Value("${catalogo.service.url}")
    private String catalogoServiceUrl;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, RestTemplate restTemplate) {
        this.pedidoRepository = pedidoRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public Pedido criarPedido(Pedido pedido){
        logger.info("Criando pedido para o cliente: {}" , pedido.getIdCliente());
        double valorTotalCalculado = 0;

        for (ItemPedido item : pedido.getItens()){
            String urlProduto = catalogoServiceUrl + "/produtos/" + item.getIdProduto() + "/itens";
            logger.info(urlProduto);
            try{
                ProdutoDTO produtoDTO = restTemplate.getForObject(urlProduto, ProdutoDTO.class);

            }catch (HttpClientErrorException.NotFound e){
                logger.warn("Produto não encontrado", item.getIdProduto());
                throw new RuntimeException("nao encontrado" + item.getIdProduto());
            }catch (
                    logger.error("Erro ao consultar produto" , e.getMessage());
                    throw new RuntimeException("erro ao consultar produto" + e.getMessage());
            )
        }
    }

    pedido.setValorTotal(valorTotalCalculado);
    pedido.setStatus('PENDENTE')

}
