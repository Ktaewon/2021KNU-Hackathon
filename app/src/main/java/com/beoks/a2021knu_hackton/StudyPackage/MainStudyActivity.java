package com.beoks.a2021knu_hackton.StudyPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beoks.a2021knu_hackton.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainStudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_study);
        setStudyPostButton();
        setBackButton();
    }

    void setBackButton(){
        ((Button)findViewById(R.id.main_study_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void setStudyPostButton(){
        FloatingActionButton fab = findViewById(R.id.study_post_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), StudyPostActivity.class);
                startActivity(intent);
            }
        });
    }
}