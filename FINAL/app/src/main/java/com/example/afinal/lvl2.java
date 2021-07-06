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

public class lvl2 extends AppCompatActivity  {
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    ImageView img;
    RadioGroup radiogroup2;
    float grados, trasX, trasY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl2);
        rbText= findViewById(R.id.rbText);
        rbRotate= findViewById(R.id.rbRotate);
        rbTranslate= findViewById(R.id.rbTranslate);
        editTxtTexto= findViewById(R.id.editTxtTexto);
        img= findViewById(R.id.img);
        radiogroup2= findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY= findViewById(R.id.txtY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtX.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);
        editTxtTexto.setVisibility(View.INVISIBLE);
    }

    public void onClickComprobar(View v){
        if (rbText.isChecked() && (editTxtTexto.getText().toString().equals("palindromos")||
                editTxtTexto.getText().toString().equals("Palindromos")
        || editTxtTexto.getText().toString().equals("palindromo")||
                editTxtTexto.getText().toString().equals("Palindromo"))){
            Toast.makeText(this, "FELICIDADES CRACK", Toast.LENGTH_LONG).show();
            Intent intent= new  Intent(this, lvl3.class);
                startActivity(intent);
                finish();
        }
        if(rbRotate.isChecked()) {
            grados= Float.parseFloat(String.valueOf(editTxtTexto.getText()));
            img.setRotation(grados);
            Toast.makeText(this, "Lo siento bro", Toast.LENGTH_SHORT).show();
        }
        if (rbTranslate.isChecked()){
            if (txtX.getText().toString().isEmpty()|| txtY.getText().toString().isEmpty()){
                Toast.makeText(this, "favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
            else {
            Toast.makeText(this, "Lo siento bro", Toast.LENGTH_SHORT).show();
            trasX= Float.parseFloat(String.valueOf(txtX.getText()));
            trasY= Float.parseFloat(String.valueOf(txtY.getText()));
            img.setTranslationX(trasX);
            img.setTranslationY(trasY);
        }}
    }
    public void uptadeRadio(View v){
        int selectedID = radiogroup2.getCheckedRadioButtonId();

        if (selectedID== rbTranslate.getId()){
            txtY.setVisibility(View.VISIBLE);
            txtX.setVisibility(View.VISIBLE);
            editTxtTexto.setVisibility(View.INVISIBLE);

        }
        if (selectedID== rbRotate.getId()){
            txtY.setVisibility(View.INVISIBLE);
            txtX.setVisibility(View.INVISIBLE);
            editTxtTexto.setVisibility(View.VISIBLE);
            editTxtTexto.setInputType(View.AUTOFILL_TYPE_LIST);
        }
        if (selectedID== rbText.getId()){
            txtY.setVisibility(View.INVISIBLE);
            txtX.setVisibility(View.INVISIBLE);
            editTxtTexto.setVisibility(View.VISIBLE);
            editTxtTexto.setInputType(View.AUTOFILL_TYPE_TEXT);
        }


    }
    public void Reiniciar(View v){
        grados=0;
        img.setRotation(grados);
        img.setTranslationY(0.0f);
        img.setTranslationX(0.0f);
    }

}