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

import java.util.Calendar;

public class lvl4 extends AppCompatActivity {
    RadioGroup radiogroup2;
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    ImageView osamayor;
    Calendar calendario = Calendar.getInstance();

    int hora = calendario.get(Calendar.HOUR_OF_DAY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl4);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        osamayor = findViewById(R.id.sol);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Son las "+hora, Toast.LENGTH_SHORT).show();
        txtX.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);
        editTxtTexto.setVisibility(View.INVISIBLE);
        osamayor.setVisibility(View.INVISIBLE);
        if(hora>=20|| hora<6){
            osamayor.setVisibility(View.VISIBLE);
        }
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
        if (rbText.isChecked()&& editTxtTexto.getText().toString().equals("osa mayor")) {

                Toast.makeText(this, "no era tan dificil", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, lvl5.class);
                    startActivity(intent);
                    finish();


        }
        else {
            Toast.makeText(this, "puedes ser o no ser paciente", Toast.LENGTH_SHORT).show();
        }

        if (rbRotate.isChecked()) {
            Toast.makeText(this, "mmmmm no", Toast.LENGTH_SHORT).show();

        }
        if (rbTranslate.isChecked()) {

            Toast.makeText(this, "demasiado mal", Toast.LENGTH_SHORT).show();
            }

        }
    public void Reiniciar(View v) {
        Intent intent = new Intent(this, lvl4.class);
        startActivity(intent);
        finish();


    }
}