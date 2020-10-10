package com.example.calculadorasalario.entity;

import com.example.calculadorasalario.enums.DeducoesIRRF;
import com.example.calculadorasalario.enums.PorcentagensIRRF;
import com.example.calculadorasalario.interfaces.ICalcular;

public class CalculaIRRF implements ICalcular {
    private double salarioBase;

    public CalculaIRRF(double salario, double inss, double dependentes) {
        this.salarioBase = this.setSalarioCalculo(salario, inss, dependentes);
    }

    private double setSalarioCalculo(double salario, double inss, double dependentes) {
        return salario - inss - (dependentes * 189.56);
    }

    @Override
    public double calcular() {
        String faixa = new FaixaIRRF(this.salarioBase).getFaixa();
        double perCent = PorcentagensIRRF.valueOf(faixa).getValor() / 100;
        double deducao = DeducoesIRRF.valueOf(faixa).getValor();
        return (this.salarioBase * perCent) - deducao;
    }
}
