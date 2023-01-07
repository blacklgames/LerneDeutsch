package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button nextButton = (Button) findViewById(R.id.btnNext) ;
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText txt = (EditText) findViewById(R.id.txtCount);
        String str = txt.getText().toString();

        if(!str.isEmpty()) {
            try {
                Integer cnt = Integer.parseInt(str);
                Intent i = new Intent(this, EnterNameActivity.class);
                i.putExtra("count", cnt);
                startActivity(i);
            } catch (Exception e) {}
        }
    }
}