package com.example.calculatorbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultBMIActivity extends AppCompatActivity {

    private TextView textViewResult;
    private ImageView imageViewAva;

    private double result;
    private boolean sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);

        textViewResult = findViewById(R.id.textViewTest);
        imageViewAva = findViewById(R.id.imageViewAva);

        Intent intent = getIntent();
        result = intent.getDoubleExtra("result", 0.0);
        sex = intent.getBooleanExtra("sex", true);


        textViewResult.setText(checkResult(sex, result));
    }

    public String checkResult(boolean sex, double result){

        String message;

        if (sex){
            message = showManResult(result);
        } else {
            message = showWomanResult(result);
        }
        return message;
    }

    public String showManResult(double result) {

        if (result <= 18.5) {
            imageViewAva.setImageResource(R.drawable.mannot);
            return "Insufficient (deficit) body weight";
        } else {
            if (result >= 25.5) {
                imageViewAva.setImageResource(R.drawable.mannot);
                return "Overweight (pre-obesity)";
            } else {
                imageViewAva.setImageResource(R.drawable.manok);
                return "Normal body weight";
            }
        }
    }

    public String showWomanResult(double result) {

        if (result <= 18) {
            imageViewAva.setImageResource(R.drawable.womannot);
            return "Insufficient (deficit) body weight";
        } else {
            if (result >= 24.5) {
                imageViewAva.setImageResource(R.drawable.womannot);
                return "Overweight (pre-obesity)";
            } else {
                imageViewAva.setImageResource(R.drawable.womanok);
                return "Normal body weight";
            }
        }
    }
}
