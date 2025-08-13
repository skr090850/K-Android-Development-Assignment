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

    EditText edtFirst, edtSecond;
    Button btnAdd, btnSub, btnMulti, btnDiv;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtFirst = findViewById(R.id.firstEdit);
        edtSecond = findViewById(R.id.SecondEdit);
        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.sub);
        btnMulti = findViewById(R.id.multi);
        btnDiv = findViewById(R.id.div);
        txtResult = findViewById(R.id.result);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edtFirst.getText().toString());
                int num2= Integer.parseInt(edtSecond.getText().toString());
                txtResult.setText(String.valueOf(num1+num2));
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edtFirst.getText().toString());
                int num2= Integer.parseInt(edtSecond.getText().toString());
                txtResult.setText(String.valueOf(num1-num2));
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edtFirst.getText().toString());
                int num2= Integer.parseInt(edtSecond.getText().toString());
                txtResult.setText(String.valueOf(num1*num2));
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Integer.parseInt(edtFirst.getText().toString());
                float num2= Integer.parseInt(edtSecond.getText().toString());
                txtResult.setText(String.valueOf(num1/num2));
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}