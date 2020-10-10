package com.example.calculadorasalario.enums;

public enum PorcentagensIRRF {
    MIN(0),
    START(7.5),
    MIDDLE(15.0),
    MAX(22.5),
    OVER(27.5);

    public double valor;
    PorcentagensIRRF(double value) {
        valor = value;
    }

    public double getValor() {
        return valor;
    }
}
