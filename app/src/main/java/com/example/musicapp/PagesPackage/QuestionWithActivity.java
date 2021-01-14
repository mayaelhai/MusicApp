package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musicapp.R;

public class QuestionWithActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1, bt2, bt3, bt4;
    private String language, where, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_with);

        initUI();
        initListeners();
    }

    private void initUI() {
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);

        language = getIntent().getStringExtra("language");
        where = getIntent().getStringExtra("where");
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
        final Intent intent = new Intent(QuestionWithActivity.this, QuestionMoodActivity.class);

        if (v.getId() == R.id.bt1) {
            intent.putExtra("with", "Friend");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt2) {
            intent.putExtra("with", "Family");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt3) {
            intent.putExtra("with", "Boyfriend");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt4) {
            intent.putExtra("with", "Alone");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("data", data);
            startActivity(intent);
        }
    }

}
