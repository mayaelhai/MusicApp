package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musicapp.R;

public class QuestionWhyActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1, bt2, bt3, bt4;
    private String language, where, with, mood, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_why);

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
        mood = getIntent().getStringExtra("mood");
        data = getIntent().getStringExtra("data");

        if (mood.equals("Happy")) {
            bt1.setText("Just a beautiful day");
            bt2.setText("I got good news");
            bt3.setText("I am in love");
            bt4.setText("I'm with people I love");
        } else if (mood.equals("Angry")) {
            bt1.setText("Breakup from boyfriend");
            bt2.setText("I lost someone I love");
            bt3.setText("Bad grade on my test");
            bt4.setText("Feel sick");
        } else if (mood.equals("Sad")) {
            bt1.setText("Angry at my parents");
            bt2.setText("I did not succeed in something");
            bt3.setText("Someone is arguing with me");
            bt4.setText("Someone was not nice to me");
        } else if (mood.equals("Active")) {
            bt1.setText("Traveler");
            bt2.setText("Running");
            bt3.setText("Party");
            bt4.setText("I do yoga");
        }
    }

    private void initListeners() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (data.equals("Get")) {
            intent = new Intent(QuestionWhyActivity.this, PlaylistActivity.class);
        } else if (data.equals("Add")) {
            intent = new Intent(QuestionWhyActivity.this, AddPlaylistActivity.class);
        }

        if (v.getId() == R.id.bt1) {
            intent.putExtra("why", bt1.getText().toString());
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("mood", mood);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt2) {
            intent.putExtra("why", bt2.getText().toString());
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("mood", mood);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt3) {
            intent.putExtra("why", bt3.getText().toString());
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("mood", mood);
            startActivity(intent);
        }
        if (v.getId() == R.id.bt4) {
            intent.putExtra("why", bt4.getText().toString());
            intent.putExtra("language", language);
            intent.putExtra("where", where);
            intent.putExtra("with", with);
            intent.putExtra("mood", mood);
            startActivity(intent);
        }
    }

}
