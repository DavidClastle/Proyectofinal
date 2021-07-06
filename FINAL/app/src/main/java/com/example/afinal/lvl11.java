package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class lvl11 extends AppCompatActivity {
    RadioGroup radiogroup2;
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    TextView X1, X2;
    float grados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl11);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        X1= findViewById(R.id.X1);
        X2= findViewById(R.id.X2);

    }
    protected void onStart() {
        super.onStart();


        txtX.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);
        X1.setRotation(45f);
        X2.setRotation(45f);

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
        if (rbText.isChecked()){
            Toast.makeText(this, "NEEL", Toast.LENGTH_SHORT).show();

        }

        if (rbRotate.isChecked()) {
            grados= Float.parseFloat(String.valueOf(editTxtTexto.getText()));
            X1.setRotation(grados+45f);
            X2.setRotation(grados+45f);
            if (X1.getRotation()==0f||X1.getRotation()==270f||X1.getRotation()==360f||X1.getRotation()==90f){
                Toast.makeText(this, "OSI OSI", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(this,lvl12.class);
                startActivity(intent);
                finish();
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
        Intent intent = new Intent(this, lvl11.class);
        startActivity(intent);
        finish();


    }
}