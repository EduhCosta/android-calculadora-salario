package com.example.calculadorasalario.entity;

import com.example.calculadorasalario.interfaces.IFaixa;

public class FaixaIRRF implements IFaixa {
    private String faixa;

    FaixaIRRF(double salarioBruto) {
        this.faixa = this.defineFaixa(salarioBruto);
    }

    private String defineFaixa(double salario) {
        if (salario <= 1093.98) {
            return "MIN";
        }
        if (salario > 1903.98 && salario <= 2826.65) {
            return "START";
        }
        if (salario > 2826.65 && salario <= 3751.05) {
            return "MIDDLE";
        }
        if (salario > 3751.05 && salario <= 4664.68) {
            return "MAX";
        }
        return "OVER";
    }

    @Override
    public String getFaixa() {
        return faixa;
    }
}
