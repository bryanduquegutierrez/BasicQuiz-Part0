package es.ulpgc.eite.da.basicquizlab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;


public class puntuacion extends AppCompatActivity {

private TextView puntos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        puntos = findViewById(R.id.puntos);

        Bundle recibirDatos = getIntent().getExtras();
        String info = recibirDatos.getString("keyDatos");
        puntos.setText(info);
    }


}