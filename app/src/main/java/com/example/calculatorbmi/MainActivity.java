package com.example.calculatorbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextWeight;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroup = findViewById(R.id.radioGroup);
    }


    public void showResult(View view) {

        if (!editTextHeight.getText().toString().isEmpty() && !editTextWeight.getText().toString().isEmpty()) {

            double height = Double.parseDouble(editTextHeight.getText().toString());
            double weight = Double.parseDouble(editTextWeight.getText().toString());

            Intent intent = new Intent(this, ResultBMIActivity.class);
            intent.putExtra("result", calculatorBMI(height, weight));
            intent.putExtra("sex", checkSex(radioGroup));
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
        }
    }

    public static double calculatorBMI(double height, double weight) {

        double result = weight / (height * height);
        result *= 10000;

        return result;
    }

    public boolean checkSex(RadioGroup radioGroup) {

        int radioId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioId);

        if (radioButton.getId() == R.id.radioButtonMan){
            return true;
        } else {
            return false;
        }
    }
}