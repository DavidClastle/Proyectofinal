package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
    }
    public void onClickBack(View v){
        finish();
    }
    public void onClicklvl1(View v){
        Intent intent= new Intent(this,lvl1.class);
        startActivity(intent);

    }
    public void onClicklvl2(View v){
        Intent intent = new Intent(this,lvl2.class);
        startActivity(intent);

    }
    public void onClicklvl3(View v){
        Intent intent = new Intent(this,lvl3.class);
        startActivity(intent);

    }
    public void onClicklvl4(View v){
        Intent intent = new Intent(this,lvl4.class);
        startActivity(intent);

    }
    public  void onClcklvl5(View v){
        Intent intent = new Intent(this, lvl5.class);
        startActivity(intent);

    }
    public  void onClcklvl6(View v){
        Intent intent = new Intent(this, lvl6.class);
        startActivity(intent);
    }
    public  void onClcklvl7(View v){
        Intent intent = new Intent(this, lvl7.class);
        startActivity(intent);

    }
    public  void onClcklvl8(View v){
        Intent intent = new Intent(this, lvl8.class);
        startActivity(intent);

    }
    public void onClicklvl9(View v){
        Intent intent = new Intent(this, lvl9.class);
        startActivity(intent);

    }
    public void onClicklvl10(View v){
        Intent intent = new Intent(this, lvl10.class);
        startActivity(intent);

    }
    public void onClick11(View v){
        Intent intent = new Intent(this,lvl11.class);
        startActivity(intent);

    }
    public void onClicklvl12(View v){
        Intent intent = new Intent(this, lvl12.class);
        startActivity(intent);

    }
    public  void  onClicklvl13(View v){
        Intent intent = new Intent(this, lvl13.class);
        startActivity(intent);

    }
    public  void onClicklvl14(View v){
        Intent intent= new Intent(this, lvl14.class);
        intent.putExtra("ganar","FELICIDADES POR COMPLETAR EL JUEGO!");
        startActivity(intent);


    }
    public  void onClicklvl15(View v){
        Intent intent= new Intent(this, lvl15.class);
        startActivity(intent);



    }


}