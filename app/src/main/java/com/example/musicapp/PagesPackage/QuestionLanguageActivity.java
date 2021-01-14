package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musicapp.R;

public class QuestionLanguageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstName, lastName;
    private Button btCont;
    private String selectLanguage = "English", data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_language);

        initUI();
        initListeners();
    }

    private void initUI() {
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        btCont = findViewById(R.id.btCont);

        data = getIntent().getStringExtra("data");
    }

    private void initListeners() {
        btCont.setOnClickListener(this);
    }

    private void showDialog() {
        final String[] language = {"English", "Hebrew"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(QuestionLanguageActivity.this);
        builder.setTitle("In what language do you prefer to hear?");

        builder.setSingleChoiceItems(language, 0, (dialog, which) -> {
            selectLanguage = language[which];
            Toast.makeText(QuestionLanguageActivity.this, "You just clicked: " + language[which], Toast.LENGTH_SHORT).show();
        });

        builder.setPositiveButton("next", (dialog, which) -> {
            dialog.dismiss();

            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("first_name", firstName.getText().toString());
            editor.putString("last_name", lastName.getText().toString());
            editor.apply();

            Intent resultsIn = new Intent(QuestionLanguageActivity.this, QuestionWhereActivity.class);
            resultsIn.putExtra("language", selectLanguage);
            resultsIn.putExtra("data", data);
            startActivity(resultsIn);
        });

        builder.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btCont) {
            showDialog();
        }
    }

}
