package com.universidad.pedidos.modelo;

public class Pedido {
    private Long id;
    private String estado;

    public Pedido(Long id) {
        this.id = id;
        this.estado = "PENDIENTE";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
