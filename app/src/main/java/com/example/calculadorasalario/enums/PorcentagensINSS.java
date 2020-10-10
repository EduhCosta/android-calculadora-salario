package com.example.calculadorasalario.enums;

public enum PorcentagensINSS {
    MIN(7.5),
    START(9.0),
    MIDDLE(12.0),
    MAX(14.0),
    OVER(713.1);

    public double valor;
    PorcentagensINSS(double value) {
        valor = value;
    }

    public double getValor() {
        return valor;
    }
}
