package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class lvl10 extends AppCompatActivity {
    RadioGroup radiogroup2;
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    ImageView  manzana;
    private SensorManager sm;
    private Sensor s;
    private SensorEventListener evento;
    private int move= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE); //Accede a los sensores
        s= sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//Representa el acelerometro
        setContentView(R.layout.activity_lvl10);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        manzana= findViewById(R.id.manzana);

    }
    @Override
    protected void onStart() {
        super.onStart();

        txtX.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);
        manzana.setVisibility(View.INVISIBLE);
        editTxtTexto.setVisibility(View.INVISIBLE);
        if(s==null){
            Toast.makeText(this, "Tu celular no cuenta con el sensor para este nivel", Toast.LENGTH_SHORT).show();
        }
        evento = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //se genera el evento del acelerometro
              //  Toast.makeText(lvl10.this, "x="+event.values[0], Toast.LENGTH_SHORT).show();
                if(event.values[0]<-4&& move==0){
                    move++;
                }
                else {
                    if(event.values[0]>4&& move==1){
                        move++;
                    }
                }
                if(move==2){
                    manzana.setVisibility(View.VISIBLE);
                    move=25;
                    manzana.setTranslationY(manzana.getTranslationY()+300);

                    Intent intent = new Intent(lvl10.this, lvl11.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();

                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sm.registerListener(evento,s,SensorManager.SENSOR_DELAY_NORMAL);

    }
    public void uptadeRadio(View v) {
        int selectedID = radiogroup2.getCheckedRadioButtonId();

        if (selectedID == rbTranslate.getId()) {
            txtY.setVisibility(View.VISIBLE);
            txtX.setVisibility(View.VISIBLE);
            editTxtTexto.setVisibility(View.INVISIBLE);

        }
        if (selectedID == rbRotate.getId()) {
            txtY.setVisibility(View.INVISIBLE);
            txtX.setVisibility(View.INVISIBLE);
            editTxtTexto.setVisibility(View.VISIBLE);
            editTxtTexto.setInputType(View.AUTOFILL_TYPE_LIST);
        }
        if (selectedID == rbText.getId()) {
            txtY.setVisibility(View.INVISIBLE);
            txtX.setVisibility(View.INVISIBLE);
            editTxtTexto.setVisibility(View.VISIBLE);
            editTxtTexto.setInputType(View.AUTOFILL_TYPE_TEXT);
        }}
    public void onClickComprobar(View v) {
        if (rbText.isChecked()) {

        Toast.makeText(this, "JAJAJ nel", Toast.LENGTH_SHORT).show();
        

        }


        if (rbRotate.isChecked()) {
            Toast.makeText(this, "mmmmm no", Toast.LENGTH_SHORT).show();

        }
        if (rbTranslate.isChecked()) {
            if (txtX.getText().toString().isEmpty()|| txtY.getText().toString().isEmpty()){
                Toast.makeText(this, "favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
            else {

            Toast.makeText(this, "demasiado mal", Toast.LENGTH_SHORT).show();
        }}

    }
    public void Reiniciar(View v) {
        Intent intent = new Intent(this, lvl4.class);
        startActivity(intent);
        finish();


    }



}