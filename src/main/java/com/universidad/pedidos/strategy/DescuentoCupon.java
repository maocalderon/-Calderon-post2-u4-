package com.universidad.pedidos.strategy;

import org.springframework.stereotype.Service;

@Service
public class DescuentoCupon implements EstrategiaDescuento {
    private static final double VALOR_CUPON = 15000.0;
    @Override
    public double calcular(double subtotal) {
        return Math.min(subtotal, VALOR_CUPON);
    }
    @Override
    public String getNombre() {
        return "Cupon (-$15.000)";
    }
}
