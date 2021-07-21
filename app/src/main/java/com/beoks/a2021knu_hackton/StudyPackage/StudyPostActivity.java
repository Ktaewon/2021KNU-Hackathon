package com.beoks.a2021knu_hackton.StudyPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beoks.a2021knu_hackton.R;

public class StudyPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_post);
        setPostStudyButton();
    }

    void setPostStudyButton(){
        ((Button)findViewById(R.id.post_study_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), StudyReadActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}