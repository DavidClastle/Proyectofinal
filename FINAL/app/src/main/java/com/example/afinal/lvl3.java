package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class lvl3 extends AppCompatActivity {
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    ImageView imgPajarito, imgJaula;
    RadioGroup radiogroup2;
    float grados, trasX, trasY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl3);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        imgPajarito = findViewById(R.id.imgPajarito);
        imgJaula= findViewById(R.id.imgJaula);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtX.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);
        editTxtTexto.setVisibility(View.INVISIBLE);
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
        if (rbText.isChecked()) {
            Toast.makeText(this, "NO NO NO", Toast.LENGTH_SHORT).show();
        }

        if (rbRotate.isChecked()) {
            grados = Float.parseFloat(String.valueOf(editTxtTexto.getText()));
            imgPajarito.setRotation(grados);
            Toast.makeText(this, "Lo siento bro", Toast.LENGTH_SHORT).show();
        }
        if (rbTranslate.isChecked()) {
            if (txtX.getText().toString().isEmpty()|| txtY.getText().toString().isEmpty()){
                Toast.makeText(this, "favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
            else {
            trasX = Float.parseFloat(String.valueOf(txtX.getText()));
            trasY = Float.parseFloat(String.valueOf(txtY.getText()));
            imgPajarito.setTranslationX(trasX);
            imgPajarito.setTranslationY(trasY);
            if (trasX>=300||trasY<=(-400)){
                Toast.makeText(this, "Deberias haber estudiado en harvard", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, lvl4.class);
                startActivity(intent);
                finish();
            }}

        }

    }
    public void Reiniciar(View v) {
        grados = 0;
        imgPajarito.setRotation(grados);
        imgPajarito.setTranslationY(0.0f);
        imgPajarito.setTranslationX(0.0f);
    }
}