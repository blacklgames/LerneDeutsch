package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Vector;

public class EnterNameActivity extends AppCompatActivity implements View.OnClickListener {

    private Vector<EditText> mTestFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Integer count = Integer.valueOf(extras.getInt("count"));
            if(count > 0) {
                mTestFields = new Vector<EditText>();
                LinearLayout layout = findViewById(R.id.layout);
                for (int i = 0; i < count; i++) {
                    EditText textfield = new EditText(this);
                    textfield.setHint(Integer.toString(i));
                    textfield.setTextSize(15);
                    layout.addView(textfield);
                    mTestFields.add(textfield);
                }
            }
        }

        Button nextButton = (Button) findViewById(R.id.btnNext) ;
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Vector<String> strVector = new Vector<String>();
        for (int i = 0; i < mTestFields.size(); i++) {
            strVector.add(mTestFields.elementAt(i).getText().toString());
        }

        if(strVector.size() > 0) {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("users", strVector);
            startActivity(i);
        }
    }
}