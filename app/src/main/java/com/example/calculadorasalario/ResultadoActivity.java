package com.example.calculadorasalario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.calculadorasalario.enums.IntentKeys;

import org.w3c.dom.Text;

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

    @Override
    protected void onStart() {
        super.onStart();
        this.setMessagesOnView();
    }


    private void setMessagesOnView() {
        this.setMessageOnElement(R.id.valSalarioBruto, this.bruto);
        this.setMessageOnElement(R.id.valINSS,-1 * this.inss);
        this.setMessageOnElement(R.id.valIRRF, -1 * this.irrf);
        this.setMessageOnElement(R.id.valDescontos, -1 * this.descontos);
        this.setMessageOnElement(R.id.valSalarioLiquido, this.liquido);
        this.setMessageOnElement(R.id.valPercentDescontos, this.percentDecontos());
    }

    private double percentDecontos() {
        return 100 - ((this.liquido / this.bruto) * 100);
    }

    @SuppressLint("SetTextI18n")
    private void setMessageOnElement(int id, double value) {
        TextView input = findViewById(id);
        input.setText(Double.toString(value));
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
        return intent.getDoubleExtra(key.getValor(), 0);
    }

    public void onClickVoltar(View view) {
        Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(backIntent);
    }
}