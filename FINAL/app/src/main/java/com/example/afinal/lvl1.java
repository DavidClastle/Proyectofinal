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

public class lvl1 extends AppCompatActivity {
     ImageView img;
     RadioButton rbText, rbRotate, rbTranslate;

     EditText editTxtTexto, txtY, txtX;
     RadioGroup radiogroup;
     float grados, trasX, trasY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);

        rbText= findViewById(R.id.rbText);
        rbRotate= findViewById(R.id.rbRotate);
        rbTranslate= findViewById(R.id.rbTranslate);
        editTxtTexto= findViewById(R.id.editTxtTexto);
        img= findViewById(R.id.img);
        radiogroup= findViewById(R.id.radiogroup2);
        txtX= findViewById(R.id.txtX);
        txtY= findViewById(R.id.txtY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtY.setVisibility(View.INVISIBLE);
        txtX.setVisibility(View.INVISIBLE);
        editTxtTexto.setVisibility(View.INVISIBLE);



    }
    public void onClickComprobar(View v){
       if (rbRotate.isChecked()){

           grados= Float.parseFloat(String.valueOf(editTxtTexto.getText()));

               img.setRotation(grados);
                if (img.getRotation()==180){
                    Toast.makeText(this, "RESPUESTA CORRECTA CRACK ;)", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(this,lvl2.class);
                    startActivity(intent);
                    finish();
                }
                else  {
                    Toast.makeText(this, "LO SIENTO VUELVE A INTENTAR", Toast.LENGTH_LONG).show();
                }
       }
       if (rbText.isChecked()){
           Toast.makeText(this, "LO SIENTO AMIGO PERA NO ES ESO", Toast.LENGTH_LONG).show();
       }
       if (rbTranslate.isChecked()){

            if (txtX.getText().toString().isEmpty()|| txtY.getText().toString().isEmpty()){
                Toast.makeText(this, "favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
            else {
                trasX = Float.parseFloat(String.valueOf(txtX.getText()));
                trasY = Float.parseFloat(String.valueOf(txtY.getText()));
                Toast.makeText(this, "NO AMIGO, PIENSALE MÁS", Toast.LENGTH_LONG).show();
                img.setTranslationX(trasX);
                img.setTranslationY(trasY);
            }       }
    }
    public void onClickReiniciar(View v){
        grados=0;
        img.setRotation(grados);
        img.setTranslationY(0.0f);
        img.setTranslationX(0.0f);
    }
    public void uptadeRadio(View v){
        int selectedID = radiogroup.getCheckedRadioButtonId();

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
}