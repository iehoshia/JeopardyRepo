package com.example.iehoshia.jeopardy;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class ReferenciaActivity extends AppCompatActivity {

    TextView tvPregunta;
    RadioButton rbP1, rbP2, rbP3, rbP4;
    String correcta;
    String sR1, sR2, sR3, sR4, usuario, valor, valor1, valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referencia);
        tvPregunta = (TextView) findViewById(R.id.textView);
        rbP1 = (RadioButton) findViewById(R.id.radioButton);
        rbP2 = (RadioButton) findViewById(R.id.radioButton2);
        rbP3 = (RadioButton) findViewById(R.id.radioButton3);
        rbP4 = (RadioButton) findViewById(R.id.radioButton4);


        Intent intent = getIntent();
        String sPregunta = intent.getStringExtra("pregunta");
        sR1 = intent.getStringExtra("r1");
        sR2 = intent.getStringExtra("r2");
        sR3 = intent.getStringExtra("r3");
        sR4 = intent.getStringExtra("r4");

        valor1 = intent.getStringExtra("valor1");
        valor2 = intent.getStringExtra("valor2");

        usuario = intent.getStringExtra("usuario");
        //Toast.makeText(getApplicationContext(), usuario + " ACTUAL",Toast.LENGTH_SHORT).show();
        correcta= intent.getStringExtra("correcta");
        valor = intent.getStringExtra("valor");


        tvPregunta.setText(sPregunta);
        rbP1.setText(sR1);
        rbP2.setText(sR2);
        rbP3.setText(sR3);
        rbP4.setText(sR4);

        rbP1.setOnClickListener(new OnClickListenerRP(rbP1));
        rbP2.setOnClickListener(new OnClickListenerRP(rbP2));
        rbP3.setOnClickListener(new OnClickListenerRP(rbP3));
        rbP4.setOnClickListener(new OnClickListenerRP(rbP4));

    }

    private class OnClickListenerRP implements View.OnClickListener {
        RadioButton rbActual;
        public OnClickListenerRP(RadioButton rbActualGen){
            rbActual = rbActualGen;
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            String respuesta = rbActual.getText().toString();
            Intent in = new Intent(ReferenciaActivity.this,
                    MainActivity.class);
            in.putExtra("usuario",usuario);
            in.putExtra("valor1",valor1);
            in.putExtra("valor2",valor2);
            String resultado="";
            if (Objects.equals(respuesta,correcta)){
                Toast.makeText(getApplicationContext(), "Respuesta correcta",
                        Toast.LENGTH_SHORT).show();
                resultado = valor;

            } else {
                Toast.makeText(getApplicationContext(), "Respuesta incorrecta",
                        Toast.LENGTH_SHORT).show();
                resultado = "0";
            }
            Integer valorAEnviar=0;
            Integer iResultado = Integer.valueOf(resultado);
            Integer iValor1 = Integer.valueOf(valor1);
            Integer iValor2 = Integer.valueOf(valor2);

            if (Objects.equals(usuario,"usuario1")){
                valorAEnviar = iValor1 + iResultado;
            }
            if (Objects.equals(usuario,"usuario2")){
                valorAEnviar = iValor2 + iResultado;
            }
            String sValorAEnviar = String.valueOf(valorAEnviar);

            in.putExtra("valor",sValorAEnviar);
            startActivity(in);
        }
    }
}









