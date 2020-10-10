package com.example.calculadorasalario.entity;

import com.example.calculadorasalario.interfaces.IFaixa;

public class FaixaSalarial implements IFaixa {
    private String faixa;

    FaixaSalarial(double salarioBruto) {
        this.faixa = this.defineFaixa(salarioBruto);
    }

    private String defineFaixa(double salario) {
        if (salario <= 1045) {
            return "MIN";
        }
        if (salario > 1045 && salario <= 2089.6) {
            return "START";
        }
        if (salario > 2089.6 && salario <= 3134.4) {
            return "MIDDLE";
        }
        if (salario > 3134.4 && salario <= 6101.06) {
            return "MAX";
        }
        return "OVER";
    }

    @Override
    public String getFaixa() {
        return faixa;
    }
}
