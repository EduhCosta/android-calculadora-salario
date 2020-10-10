package com.example.calculadorasalario.entity;

import com.example.calculadorasalario.enums.DeducoesINSS;
import com.example.calculadorasalario.enums.PorcentagensINSS;
import com.example.calculadorasalario.interfaces.ICalcular;

public class CalculaINSS implements ICalcular {
    private double salarioBase;

    public CalculaINSS(double salario) {
        this.salarioBase = salario;
    }

    @Override
    public double calcular() {
        String faixa = new FaixaSalarial(this.salarioBase).getFaixa();
        if ("OVER".contentEquals(faixa)) {
            return PorcentagensINSS.valueOf(faixa).getValor();
        }

        double perCent = PorcentagensINSS.valueOf(faixa).getValor() / 100;
        double deducao = DeducoesINSS.valueOf(faixa).getValor();
        double inssVal = (this.salarioBase * perCent) - deducao;
        return inssVal;
    }
}
