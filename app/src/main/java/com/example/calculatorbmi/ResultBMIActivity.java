package com.example.calculatorbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultBMIActivity extends AppCompatActivity {

    private TextView textViewResult;
    private ImageView imageViewAva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);

        textViewResult = findViewById(R.id.textViewTest);
        imageViewAva = findViewById(R.id.imageViewAva);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        boolean sex = intent.getBooleanExtra("sex", true);

        if (sex) {
            imageViewAva.setImageResource(R.drawable.manok);
        } else {
            imageViewAva.setImageResource(R.drawable.womanok);
        }

        textViewResult.setText(result);
    }
}
