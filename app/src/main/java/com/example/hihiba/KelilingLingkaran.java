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

public class KelilingLingkaran extends AppCompatActivity {
    EditText editJari, editDiameter;
    TextView result;
    Button btnBack, btnHitung, btnHapus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keliling_lingkaran);
        editJari = findViewById(R.id.editJari);
        editDiameter = findViewById(R.id.editDiameter);
        btnBack = findViewById(R.id.btnBack);
        btnHitung = findViewById(R.id.btnHitung);
        btnHapus = findViewById(R.id.btnHapus);

        buttonListener();
        editTextListener();

    }


    private void editTextListener() {
        editDiameter.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            editJari.setEnabled(charSequence.length() <= 0);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    });

        editJari.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            editDiameter.setEnabled(charSequence.length() <= 0);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    });
    }

    private void buttonListener() {
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDiameter.setText("");
                editJari.setText("");
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KelilingLingkaran.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double diameter, jarijari;
                diameter = 0;
                jarijari = 0;
                // check diameter and jari jari is empty
                if (editDiameter.getText().toString().isEmpty()) {
                    if (!editJari.getText().toString().isEmpty()) {
                        jarijari = Double.parseDouble(editJari.getText().toString());
                    }
                } else {
                    if (!editDiameter.getText().toString().isEmpty()) {
                        diameter = Double.parseDouble(editDiameter.getText().toString());
                    }
                }

                Calculate calculate = new Calculate(diameter, jarijari, "keliling");
                double res = calculate.hitung();
                result = (TextView) findViewById(R.id.result);
                result.setText(String.valueOf(res));
            }
        });



    }


}
