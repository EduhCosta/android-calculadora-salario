package com.example.calculadorasalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.calculadorasalario.enums.IntentKeys;

public class ResultadoActivity extends AppCompatActivity {
    private double bruto;
    private double inss;
    private double irrf;
    private double descontos;
    private double liquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.getIntentMessages();
    }

    private void getIntentMessages() {
        Intent msgIntent = getIntent();
        this.bruto = getMessageFromIntent(IntentKeys.SALARIO_BRUTO, msgIntent);
        this.inss =  getMessageFromIntent(IntentKeys.INSS, msgIntent);
        this.irrf = getMessageFromIntent(IntentKeys.IRRF, msgIntent);
        this.descontos = getMessageFromIntent(IntentKeys.DESCONTOS, msgIntent);
        this.liquido = getMessageFromIntent(IntentKeys.LIQUIDO, msgIntent);
    }

    private double getMessageFromIntent(IntentKeys key, Intent intent) {
        String msg = intent.getStringExtra(key.getValor());
        double doubleParsed = Double.parseDouble(msg);
        return doubleParsed;
    }
}