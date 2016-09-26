package com.example.iehoshia.jeopardy;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "MainActivity";
    Button btnNombre;

    String usuario,valor, valor1, valor2;
    TextView tvUsuario1, tvUsuario2;



    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNombre = (Button) findViewById(R.id.button);

        btnNombre.setOnClickListener(new OnClickListenerVariable());

        tvUsuario1 = (TextView) findViewById(R.id.textView5);
        tvUsuario2 = (TextView) findViewById(R.id.textView6);
        Intent intent = getIntent();
        usuario = intent.getStringExtra("usuario");
        valor= intent.getStringExtra("valor");
        valor1= intent.getStringExtra("valor1");
        valor2= intent.getStringExtra("valor2");

        Toast.makeText(getApplicationContext(), usuario +" linea 35", Toast.LENGTH_SHORT).show();
        if (Objects.equals(usuario , "usuario1")) {
            tvUsuario1.setText(valor);
            tvUsuario2.setText(valor2);

        }
        if(Objects.equals(usuario , "usuario2")) {
            tvUsuario2.setText(valor);
            tvUsuario1.setText(valor1);
        }

        if ( Objects.equals(usuario,"usuario2")  || usuario==null){
            usuario = "usuario1";
        }else {
            usuario = "usuario2";
        }


    }

    private class OnClickListenerVariable implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String sPregunta, sR1, sR2, sR3, sR4, valor1, valor2;
            sPregunta = "¿Cuál es la ciudad más grande del mundo?";
            sR1 = "Ciudad México";
            sR2 = "Nueva York";
            sR3 = "Tokio";
            sR4 = "Shangai";
            valor1 = tvUsuario1.getText().toString();
            valor2 = tvUsuario2.getText().toString();

            Intent in = new Intent(MainActivity.this, ReferenciaActivity.class);
            in.putExtra("pregunta",sPregunta);
            in.putExtra("r1",sR1);
            in.putExtra("r2",sR2);
            in.putExtra("r3",sR3);
            in.putExtra("r4",sR4);
            in.putExtra("valor1",valor1);
            in.putExtra("valor2",valor2);
            in.putExtra("correcta",sR4);
            in.putExtra("valor","100");
            in.putExtra("usuario",usuario);

            startActivity(in);
        }
    }
}
