package com.susnjara.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    private EditText heightEditText;
    private EditText weightEditText;
    private Button calculateButton;
    private TextView resultTextView;
    private TextView bmiTextView;
    private ImageView bmiImage;
    private TextView bmixTextView;


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
        bmiImage = findViewById(R.id.bmiImage);
        bmixTextView = findViewById(R.id.bmixTextView);

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
                bmiImage.setVisibility(View.VISIBLE);
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
            bmiTextView.setText("Underweight");
            bmixTextView.setTextColor(Color.rgb(83, 193, 237));
        }
        else if(bmi >= 18.5 && bmi < 24.9)
        {
            bmiTextView.setText("Healthy");
            bmixTextView.setTextColor(Color.rgb(56, 242, 62));
        }
        else if(bmi >= 24.9 && bmi < 29.9)
        {
            bmiTextView.setText("Overweight");
            bmixTextView.setTextColor(Color.rgb(241, 252, 76));
        }
        else if(bmi >= 29.9 && bmi < 34.9)
        {
            bmiTextView.setText("Obese");
            bmixTextView.setTextColor(Color.rgb(255, 164, 36));
        }
        else
        {
            bmiTextView.setText(" Extremely obese");
            bmixTextView.setTextColor(Color.rgb(255, 0, 21));
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