package com.example.iehoshia.jeopardy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNombre = (Button) findViewById(R.id.button);

        btnNombre.setOnClickListener(new OnClickListenerVariable());
    }

    private class OnClickListenerVariable implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String sPregunta, sR1, sR2, sR3, sR4;
            sPregunta = "¿Cuál es la ciudad más grande del mundo?";
            sR1 = "Ciudad México";
            sR2 = "Neeva York";
            sR3 = "Tokio";
            sR4 = "Shangai";
            Intent in = new Intent(MainActivity.this, ReferenciaActivity.class);
            in.putExtra("pregunta",sPregunta);
            in.putExtra("r1",sR1);
            in.putExtra("r2",sR2);
            in.putExtra("r3",sR3);
            in.putExtra("r4",sR4);
            in.putExtra("correcta",sR1);
            startActivity(in);
        }
    }
}
