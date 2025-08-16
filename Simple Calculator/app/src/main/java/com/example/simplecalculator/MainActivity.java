package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnSub, btnMulti, btnDiv, btnAc, btnPercentage, btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,btnBackspace,btnEqualToo;
    TextView txtResult;
    View cursorView;
    Animation blinkAnimation;
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
        cursorView = findViewById(R.id.cursorView);
        blinkAnimation = AnimationUtils.loadAnimation(this,R.anim.blink);
        cursorView.startAnimation(blinkAnimation);
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("0");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString()+"%");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString()+"/");
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString()+"x");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString()+"+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString()+"-");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"1"));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"2"));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"3"));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"4"));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"5"));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"6"));
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"7"));
            }
        });btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"8"));
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"9"));
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(formatNumber(txtResult.getText().toString()+"0"));
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString()+".");
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
                String exp = txtResult.getText().toString();
                String cleanExp = exp.replace(",","").replace("x","*");
                String result = onEqual(cleanExp);
                txtResult.setText(formatNumber(result));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private String formatNumber(String expression) {
        String[] parts = expression.split("(?<=[-+X/.])|(?=[-+X/.])");
        StringBuilder formattedExpression = new StringBuilder();

        for (String part : parts) {
            if (part.matches("[-+X/.]")) {
                formattedExpression.append(part);
            } else {
                try {
                    String cleanPart = part.replace(",", "");
                    if (!cleanPart.isEmpty()) {
                        double parsed = Double.parseDouble(cleanPart);
                        DecimalFormat formatter = new DecimalFormat("#,###");
                        formattedExpression.append(formatter.format(parsed));
                    }
                } catch (NumberFormatException e) {
                    formattedExpression.append(part);
                }
            }
        }
        return formattedExpression.toString();
    }
    private String onEqual(String expression) {
        String[] numbers = expression.split("[-+*/]");
        String operators = expression.replaceAll("[0-9.]", "");
        double result = Double.parseDouble(numbers[0]);
        for (int i = 0; i < operators.length(); i++) {
            char op = operators.charAt(i);
            double nextNumber = Double.parseDouble(numbers[i + 1]);
            if (op == '+') {
                result += nextNumber;
            } else if (op == '-') {
                result -= nextNumber;
            } else if (op == '*') {
                result *= nextNumber;
            } else if (op == '/') {
                result /= nextNumber;
            }
        }
        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            return String.valueOf(result);
        }
    }
}