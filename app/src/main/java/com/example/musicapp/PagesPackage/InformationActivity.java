package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musicapp.R;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        initUI();
        initListeners();
    }

    private void initUI() {
        btBack = findViewById(R.id.btBack);
    }

    private void initListeners() {
        btBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btBack) {
            Intent resultsIn = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(resultsIn);
        }
    }

}
