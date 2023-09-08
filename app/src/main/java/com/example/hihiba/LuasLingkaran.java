package com.example.hihiba;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class LuasLingkaran extends AppCompatActivity {
    EditText diameterEdit, jarijariEdit;
    Button hitung, back, reset;
    TextView resu;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luas_lingkaran);
        diameterEdit = findViewById(R.id.diameterEdit);
        jarijariEdit = findViewById(R.id.jarijariEdit);
        hitung = findViewById(R.id.hitung);
        back = findViewById(R.id.back);
        reset = findViewById(R.id.reset);
        listenerBtn();


        diameterEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                jarijariEdit.setEnabled(charSequence.length() <= 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        jarijariEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                diameterEdit.setEnabled(charSequence.length() <= 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    private void listenerBtn() {

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diameterEdit.setText("");
                jarijariEdit.setText("");
                TextView resu = (TextView) findViewById(R.id.resu);
                resu.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LuasLingkaran.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double diameter, jarijari;
                diameter = 0;
                jarijari = 0;
                // check diameter and jari jari is empty
                if (diameterEdit.getText().toString().isEmpty()) {
                    if (!jarijariEdit.getText().toString().isEmpty()) {
                        jarijari = Double.parseDouble(jarijariEdit.getText().toString());
                    }
                } else {
                    if (!diameterEdit.getText().toString().isEmpty()) {
                        diameter = Double.parseDouble(diameterEdit.getText().toString());
                    }
                }

                Calculate calculate = new Calculate(diameter, jarijari, "luas");
                double result = calculate.hitung();
                resu = findViewById(R.id.resu);
                resu.setText(String.valueOf(result));
            }
        });


    }
}
