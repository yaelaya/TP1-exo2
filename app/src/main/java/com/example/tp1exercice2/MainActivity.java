package com.example.tp1exercice2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSurface, editTextPieces;
    private CheckBox checkBoxPiscine;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSurface = findViewById(R.id.Surface);
        editTextPieces = findViewById(R.id.Piece);
        checkBoxPiscine = findViewById(R.id.checkBox);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.button);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTax();
            }
        });
    }

    private void calculateTax() {

        int surface = Integer.parseInt(editTextSurface.getText().toString());
        int pieces = Integer.parseInt(editTextPieces.getText().toString());
        boolean hasPiscine = checkBoxPiscine.isChecked();

        int impotBase = surface * 2;

        int impotSupplementaire = pieces * 50;
        if (hasPiscine) {
            impotSupplementaire += 100;
        }

        int totalImpots = impotBase + impotSupplementaire;

        String result = "Impôts de base: " + impotBase +
                "\nImpôts supplémentaire: " + impotSupplementaire +
                "\nTotal Impôts: " + totalImpots;
        textViewResult.setText(result);
    }

}
