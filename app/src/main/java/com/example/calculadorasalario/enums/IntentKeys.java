package com.example.calculadorasalario.enums;

public enum IntentKeys {
    SALARIO_BRUTO("MSG_SALARIO_BRUTO"),
    INSS("MSG_ISS"),
    IRRF("MSG_IRRF"),
    DESCONTOS("MSG_DESCONTOS"),
    LIQUIDO("MSG_SALARIO_LIQUIDO");

    private String valor;
    IntentKeys(String value) {
        valor = value;
    }

    public String getValor() {
        return valor;
    }
}
