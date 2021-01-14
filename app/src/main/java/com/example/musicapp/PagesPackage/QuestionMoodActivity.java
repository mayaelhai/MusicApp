package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musicapp.R;

public class QuestionMoodActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1, bt2, bt3, bt4;
    private String language, where, with, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_mood);

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
        with = getIntent().getStringExtra("with");
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
        final Intent intent = new Intent(QuestionMoodActivity.this, QuestionWhyActivity.class);

        if (v.getId() == R.id.bt1) {
            intent.putExtra("mood", "Happy");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt2) {
            intent.putExtra("mood", "Angry");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt3) {
            intent.putExtra("mood", "Sad");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("data", data);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt4) {
            intent.putExtra("mood", "Active");
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("data", data);
            startActivity(intent);
        }
    }

}
