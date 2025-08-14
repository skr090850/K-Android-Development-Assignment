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
    EditText txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnAc = findViewById(R.id.btnAc);
        btnPercentage = findViewById(R.id.btnPercentage);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btn0 = findViewById(R.id.btnZero);
        btnDot = findViewById(R.id.btnDot);
        btnBackspace = findViewById(R.id.btnBackSpace);
        btnEqualToo = findViewById(R.id.btnEqualToo);
        txtResult = findViewById(R.id.txtResult);
        txtResult.requestFocus();
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("%");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("/");
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("x");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("-");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("7");
            }
        });btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("0");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(".");
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
            }
        });
        btnEqualToo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");

            }
        });

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