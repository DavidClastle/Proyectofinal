package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickNiveles(View v){
        Intent intent = new Intent(this,Seleccion.class);
        startActivity(intent);
    }
    public void onClickInstrucciones(View v){
        Intent intent= new Intent(this,Intru.class);
        startActivity(intent);
    }
    public void onClickAlarma (View v){
        Intent intent= new Intent(this, Alarma.class);
        startActivity(intent);

    }


}


