package com.universidad.pedidos.strategy;

import org.springframework.stereotype.Service;

@Service
public class DescuentoVIP implements EstrategiaDescuento {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.30;
    }
    @Override
    public String getNombre() {
        return "VIP (30%)";
    }
}
