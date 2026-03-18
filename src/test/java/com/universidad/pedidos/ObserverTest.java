package com.universidad.pedidos;

import com.universidad.pedidos.modelo.Pedido;
import com.universidad.pedidos.observer.GestorPedidosService;
import com.universidad.pedidos.observer.PedidoCanceladoEvent;
import com.universidad.pedidos.observer.PedidoConfirmadoEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {GestorPedidosService.class})
class ObserverTest {
    static class TestSubscriber {
        boolean confirmado = false;
        boolean cancelado = false;
        @EventListener
        public void onConfirmado(PedidoConfirmadoEvent e) { confirmado = true; }
        @EventListener
        public void onCancelado(PedidoCanceladoEvent e) { cancelado = true; }
    }

    @Test
    void testPublicaEventoConfirmado() {
        ApplicationEventPublisher publisher = event -> {};
        GestorPedidosService gestor = new GestorPedidosService(publisher);
        Pedido pedido = new Pedido(1L);
        // No excepción al publicar evento
        assertDoesNotThrow(() -> gestor.confirmarPedido(pedido));
        assertEquals("CONFIRMADO", pedido.getEstado());
    }

    @Test
    void testPublicaEventoCancelado() {
        ApplicationEventPublisher publisher = event -> {};
        GestorPedidosService gestor = new GestorPedidosService(publisher);
        Pedido pedido = new Pedido(2L);
        assertDoesNotThrow(() -> gestor.cancelarPedido(pedido));
        assertEquals("CANCELADO", pedido.getEstado());
    }
}
