package com.example.founderdetailsapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Founder extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_founder);

        int image = getIntent().getIntExtra("IMAGE_KEY",0);
        String title = getIntent().getStringExtra("TITLE_KEY");
        String decs = getIntent().getStringExtra("DECS_KEY");

        ImageView founderImage = findViewById(R.id.founder_image);
        TextView founderTitle = findViewById(R.id.founder_heading);
        TextView founderDesc = findViewById(R.id.founder_decs);

        founderImage.setImageResource(image);
        founderTitle.setText(title);
        founderDesc.setText(decs);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}