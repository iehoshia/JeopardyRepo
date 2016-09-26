package com.example.iehoshia.jeopardy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ReferenciaActivity extends AppCompatActivity {

    TextView tvPregunta;
    RadioButton rbP1, rbP2, rbP3, rbP4;
    String correcta;
    String sR1, sR2, sR3, sR4, usuario, valor;

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
        usuario = intent.getStringExtra("usuario");
        correcta= intent.getStringExtra("correcta");
        valor = intent.getStringExtra("valor");


        tvPregunta.setText(sPregunta);
        rbP1.setText(sR1);
        rbP2.setText(sR2);
        rbP3.setText(sR3);
        rbP4.setText(sR4);

        rbP1.setOnClickListener(new OnClickListenerRP1());

    }

    private class OnClickListenerRP1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String resultado = sR1;
            Intent in = new Intent(ReferenciaActivity.this,
                    MainActivity.class);
            in.putExtra("usuario",usuario);

            if (resultado == correcta){
                Toast.makeText(getApplicationContext(), "Respuesta correcto",
                        Toast.LENGTH_SHORT).show();
                in.putExtra("valor",valor);

            } else {
                Toast.makeText(getApplicationContext(), "Respuesta incorrecta",
                        Toast.LENGTH_SHORT).show();
                in.putExtra("valor",0);
            }
            startActivity(in);
        }
    }
}









