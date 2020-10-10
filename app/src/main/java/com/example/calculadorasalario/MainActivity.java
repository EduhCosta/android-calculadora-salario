package com.example.calculadorasalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.calculadorasalario.entity.CalculaINSS;
import com.example.calculadorasalario.entity.CalculaIRRF;
import com.example.calculadorasalario.enums.IntentKeys;

public class MainActivity extends AppCompatActivity {
    private double bruto;
    private double inss;
    private double irrf;
    private double descontos;
    private double liquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalcular(View view) {
        double bruto = this.getContentById(R.id.edtSalarioBruto);
        double dependentes = this.getContentById(R.id.edtNumeroDependentes);
        double descontos = this.getContentById(R.id.edtOutrosDescontos);
        double inss = new CalculaINSS(bruto).calcular();
        double irrf = new CalculaIRRF(bruto, inss, dependentes).calcular();
        double somaDescontos = descontos + inss + irrf;
        double liquido = bruto - somaDescontos;
        this.bruto = bruto;
        this.descontos = descontos;
        this.inss = inss;
        this.irrf = irrf;
        this.liquido = liquido;

        Intent msg = this.createIntent();
        this.setMessages(msg);
        startActivity(msg);
    }

    private void setMessages(Intent intent) {
        this.putParam(intent, IntentKeys.SALARIO_BRUTO.getValor(), this.bruto);
        this.putParam(intent, IntentKeys.INSS.getValor(), this.inss);
        this.putParam(intent, IntentKeys.IRRF.getValor(), this.irrf);
        this.putParam(intent, IntentKeys.DESCONTOS.getValor(), this.descontos);
        this.putParam(intent, IntentKeys.LIQUIDO.getValor(), this.liquido);
    }

    private Intent createIntent() {
        Intent msgIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        return msgIntent;
    }

    private void putParam(Intent intent, String code, double value) {
        intent.putExtra(code, value);
    }

    private double getContentById(int id) {
        EditText edt = findViewById(id);
        String content = edt.getText().toString();
        double value = 0;
        if (!"".equals(content)){
            value = Double.parseDouble(content);
        }
        return value;
    }
}