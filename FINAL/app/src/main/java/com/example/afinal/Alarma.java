package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Alarma extends AppCompatActivity {
    Button alarma;
    EditText minutos, hora, titulo;
    int Hora, Minutos;
    String Titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);
        alarma= findViewById(R.id.alarma);
        minutos = findViewById(R.id.minutos);
        hora = findViewById(R.id.hora);
        titulo= findViewById(R.id.titulo);

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Hora= Integer.parseInt(String.valueOf(hora.getText()));
                Minutos= Integer.parseInt(String.valueOf(minutos.getText()));
                Titulo=titulo.getText().toString();
                setAlarma(Titulo, Hora, Minutos);
            }
        });
    }


    public void setAlarma(String mensaje, int hora, int minutos) {
        Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM)
        .putExtra(AlarmClock.EXTRA_MESSAGE, mensaje)
        .putExtra(AlarmClock.EXTRA_HOUR, hora)
        .putExtra(AlarmClock.EXTRA_MINUTES, minutos);
        //ESTO COMPRUEBA SI LA ALARMA ESTA DISPONIBLE
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "DESCARGA UNA ALARMA AHUEVONADO CULIADO", Toast.LENGTH_SHORT).show();
        }
    }
}