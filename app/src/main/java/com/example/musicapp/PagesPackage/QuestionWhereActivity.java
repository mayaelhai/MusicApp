package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musicapp.R;

public class QuestionWhereActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1, bt2, bt3, bt4;
    private String language, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_where);

        initUI();
        initListeners();
    }

    private void initUI() {
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);

        language = getIntent().getStringExtra("language");
        data = getIntent().getStringExtra("data");
    }

    private void initListeners() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Intent intent = new Intent(QuestionWhereActivity.this, QuestionWithActivity.class);

        if (v.getId() == R.id.bt1) {
            intent.putExtra("where", "In the car");
            intent.putExtra("language", language);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt2) {
            intent.putExtra("where", "In bed");
            intent.putExtra("language", language);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt3) {
            intent.putExtra("where", "In nature");
            intent.putExtra("language", language);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt4) {
            intent.putExtra("where", "At a friend's house");
            intent.putExtra("language", language);
            intent.putExtra("data", data);
            startActivity(intent);
        }
    }

}
