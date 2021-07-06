package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class lvl15 extends AppCompatActivity {
    RadioGroup radiogroup2;
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    TextView txtGanar;
    float grados;
    ImageButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl15);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtGanar = findViewById(R.id.txtGanar);
        play = findViewById(R.id.play);

    }
    protected void onStart() {
        super.onStart();

        txtX.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);

        editTxtTexto.setVisibility(View.INVISIBLE);
        MediaPlayer mp= MediaPlayer.create(this, R.raw.reves);
        mp.start();



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
        }
    }
    public void onClickComprobar(View v) {

        if (rbText.isChecked()){
            if (editTxtTexto.getText().toString().equals("yo soy tu padre")||editTxtTexto.getText().toString().equals("Yo soy tu padre")){
                Toast.makeText(this, "Felicidades por completar toda la prueba!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "No se que tan equivocado estes", Toast.LENGTH_SHORT).show();
            }
        }

        if (rbRotate.isChecked()) {
            grados= Float.parseFloat(String.valueOf(editTxtTexto.getText()));
            play.setRotation(grados+180);

        }
        if (rbTranslate.isChecked()) {
            Toast.makeText(this, ":0", Toast.LENGTH_SHORT).show();

        }

    }
    public void Reiniciar(View v) {
        Intent intent= new Intent(this, lvl15.class);
        finish();
        }
        public void Sonido(View v){
            if(play.getRotation()==0|| play.getRotation()==360) {
                MediaPlayer mp = MediaPlayer.create(this, R.raw.padre);
                mp.start();
            }
            else {
                MediaPlayer mp= MediaPlayer.create(this, R.raw.reves);
                mp.start();
            }
        }


    }




