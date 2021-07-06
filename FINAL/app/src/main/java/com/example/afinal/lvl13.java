package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class lvl13 extends AppCompatActivity {
    RadioGroup radiogroup2;
    RadioButton rbText, rbRotate, rbTranslate;
    EditText editTxtTexto, txtY, txtX;
    boolean isOn= false;
    TextView crono;
    Thread cronos;
    int mili=0, seg= 0, minutos=0;
    Handler h= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl13);
        rbText = findViewById(R.id.rbText);
        rbRotate = findViewById(R.id.rbRotate);
        rbTranslate = findViewById(R.id.rbTranslate);
        editTxtTexto = findViewById(R.id.editTxtTexto);
        radiogroup2 = findViewById(R.id.radiogroup2);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        crono= findViewById(R.id.crono);

    }
    protected void onStart() {
        super.onStart();
        isOn=true;
        txtX.setVisibility(View.INVISIBLE);
        editTxtTexto.setVisibility(View.INVISIBLE);
        txtY.setVisibility(View.INVISIBLE);
        cronos= new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(isOn){
                        try {
                            Thread.sleep(1);

                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        mili++;
                        if(mili==999){
                            seg++;
                            mili= 0;
                        }
                        if (seg==59){
                            minutos++;
                            seg=0;
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                           String m= "", s="",mi="";
                           if (mili<10){
                               m="00"+mili;
                           }
                           else if(mili<100){
                               m= "0"+mili;
                           }
                           else{
                               m=""+mili;
                           }
                           if(seg<10){
                               s="0"+seg;
                           }
                           else{
                               s=""+seg;

                           }
                           if(minutos<10){
                               mi= "0"+minutos;
                           }
                           else {
                               mi= ""+minutos;
                           }
                           crono.setText(mi+":"+s+":"+m);
                            }
                        });
                    }

                }
            }
        });
        cronos.start();



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
        if (rbText.isChecked()&& (editTxtTexto.getText().toString().equals("Stop")|| editTxtTexto.getText().toString().equals("stop"))) {

            Toast.makeText(this, "Ya me estaba estresando", Toast.LENGTH_LONG).show();
            isOn=false;
            Intent intent= new Intent(this, lvl14.class);
            startActivity(intent);
            finish();



        }
        else{
            Toast.makeText(this, "no lo se rick", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, lvl12.class);
        startActivity(intent);
        finish();


    }
}