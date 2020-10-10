package com.example.calculadorasalario.enums;

public enum DeducoesINSS {
    MIN(0),
    START(15.67),
    MIDDLE(78.36),
    MAX(141.05),
    OVER(0);

    public double valor;
    DeducoesINSS(double value) {
        valor = value;
    }

    public double getValor() {
        return valor;
    }
}
