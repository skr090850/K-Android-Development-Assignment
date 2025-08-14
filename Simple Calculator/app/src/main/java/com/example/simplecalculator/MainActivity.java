package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnSub, btnMulti, btnDiv, btnAc, btnPercentage, btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,btnBackspace,btnEqualToo;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        txtResult = findViewById(R.id.result);
//
//
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int num1 = Integer.parseInt(edtFirst.getText().toString());
//                int num2= Integer.parseInt(edtSecond.getText().toString());
//                txtResult.setText(String.valueOf(num1+num2));
//            }
//        });
//        btnSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int num1 = Integer.parseInt(edtFirst.getText().toString());
//                int num2= Integer.parseInt(edtSecond.getText().toString());
//                txtResult.setText(String.valueOf(num1-num2));
//            }
//        });
//        btnMulti.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int num1 = Integer.parseInt(edtFirst.getText().toString());
//                int num2= Integer.parseInt(edtSecond.getText().toString());
//                txtResult.setText(String.valueOf(num1*num2));
//            }
//        });
//        btnDiv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                float num1 = Integer.parseInt(edtFirst.getText().toString());
//                float num2= Integer.parseInt(edtSecond.getText().toString());
//                txtResult.setText(String.valueOf(num1/num2));
//            }
//        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}