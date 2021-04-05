package com.susnjara.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    private EditText heightEditText;
    private EditText weightEditText;
    private Button calculateButton;
    private TextView resultTextView;
    private TextView bmiTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "create");

        setView();

    }

    private void setView(){
        Log.d(TAG, "setView");
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);
        bmiTextView = findViewById(R.id.bmiTextView);

        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Click");
        String heightString = heightEditText.getText().toString();
        String weightString = weightEditText.getText().toString();

        if(heightString!=null && weightString!=null && !("").equals(heightString) && !("").equals(weightString)) {
            double height = Double.parseDouble(heightString);
            Log.d(TAG, "height" + height);
            double weight = Double.parseDouble(weightString);
            Log.d(TAG, "weight" + weight);
            double bmi = weight / (height * height);
            Log.d(TAG, "bmi" + bmi);
            if(height > 1 && height < 2.5 && weight > 35 && weight < 350)
            {
                resultTextView.setText(String.format("%.2f", bmi));
                checkBmiState(bmi);
            }
            else{
                resultTextView.setText("Invalid values");
            }
        }
        else{
            resultTextView.setText("Invalid values");
        }
    }

    protected void checkBmiState(double bmi){
        if(bmi < 18.5)
        {
            bmiTextView.setText("Pothranjen");
        }
        else if(bmi >= 18.5 && bmi < 24.9)
        {
            bmiTextView.setText("Zdrav");
        }
        else if(bmi >= 24.9 && bmi < 29.9)
        {
            bmiTextView.setText("Debeo");
        }
        else if(bmi >= 29.9 && bmi < 34.9)
        {
            bmiTextView.setText("Pretil");
        }
        else
        {
            bmiTextView.setText(" Ekstremno pretil");
        }

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }
    public MainActivity() {
        super();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}