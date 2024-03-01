package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView txv;
       EditText editWeight,editHeightFt,editHeightIn;
       Button btncalculate;
       LinearLayout linearM;


       txv = findViewById(R.id.txv);
       editWeight = findViewById(R.id.editWeight);
       editHeightFt = findViewById(R.id.heightFt);
       editHeightIn = findViewById(R.id.heightIn);
       btncalculate= findViewById(R.id.btncalculate);
       linearM = findViewById(R.id.linearM);



       btncalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             int weight = Integer.parseInt( editWeight.getText().toString());
             int heightft = Integer.parseInt(editHeightFt.getText().toString());
               int heightin = Integer.parseInt(editHeightIn.getText().toString());

               int totalInches = heightft*12 + heightin;
               double totalCm = totalInches*2.53;
               double totalm=totalCm/100;
               double bmi = weight/(totalm*totalm);
               if (bmi>25){
                   txv.setText("You are over Weight");
                   linearM.setBackgroundColor( getResources().getColor(R.color.overweight));
               } else if (bmi<18) {
                   txv.setText("You are UnderWeight");
                   linearM.setBackgroundColor( getResources().getColor(R.color.underweight));
               }
               else {
                   txv.setText("You're Healthy");
                   linearM.setBackgroundColor( getResources().getColor(R.color.healthy));
               }

           }
       });



    }
}
