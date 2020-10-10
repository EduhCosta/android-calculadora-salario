package com.example.calculadorasalario.enums;

public enum DeducoesIRRF {
    MIN(0),
    START(142.8),
    MIDDLE(354.8),
    MAX(636.13),
    OVER(869.36);

    public double valor;
    DeducoesIRRF(double value) {
        valor = value;
    }

    public double getValor() {
        return valor;
    }
}
