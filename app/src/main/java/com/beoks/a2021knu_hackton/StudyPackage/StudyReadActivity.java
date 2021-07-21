package com.beoks.a2021knu_hackton.StudyPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beoks.a2021knu_hackton.R;

public class StudyReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_read);
        setReadCancelButton();
    }

    //study_read_cancel_button
    void setReadCancelButton(){//post_study_button
        ((Button)findViewById(R.id.study_read_cancel_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainStudyActivity.class);
                startActivity(intent);
            }
        });
    }
}