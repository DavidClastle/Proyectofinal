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

public class lvl14 extends AppCompatActivity {
    RadioGroup radiogroup2;
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    ImageView reloj;
    float  grados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl14);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        reloj= findViewById(R.id.reloj);
    }

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
            Toast.makeText(this, "Torta de tamal", Toast.LENGTH_SHORT).show();
        }


        if (rbRotate.isChecked()) {

            grados= Float.parseFloat(String.valueOf(editTxtTexto.getText()));

            reloj.setRotation(grados);
            if (reloj.getRotation()==180){
                Toast.makeText(this, "RESPUESTA CORRECTA CRACK ;)", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(this, lvl15.class);
                finish();
            }
            else {
                Toast.makeText(this, "LO SIENTO VUELVE A INTENTAR", Toast.LENGTH_LONG).show();
            }
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
        Intent intent = new Intent(this, lvl14.class);
        startActivity(intent);
        finish();
    }
}