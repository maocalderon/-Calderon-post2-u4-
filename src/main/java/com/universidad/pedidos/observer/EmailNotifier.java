package com.universidad.pedidos.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.universidad.pedidos.modelo.Pedido;

@Component
public class EmailNotifier {
    @EventListener
    public void onConfirmado(PedidoConfirmadoEvent e) {
        System.out.println("[EMAIL] Confirmacion enviada para pedido: " + e.getPedido().getId());
    }
    @EventListener
    public void onCancelado(PedidoCanceladoEvent e) {
        System.out.println("[EMAIL] Aviso de cancelacion enviado para: " + e.getPedido().getId());
    }
}
