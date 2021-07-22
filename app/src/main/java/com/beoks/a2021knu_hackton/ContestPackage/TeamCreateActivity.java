package com.beoks.a2021knu_hackton.ContestPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.beoks.a2021knu_hackton.Post;
import com.beoks.a2021knu_hackton.R;
import com.google.android.material.button.MaterialButton;

import java.util.Date;

public class TeamCreateActivity extends AppCompatActivity {
    Post post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);
        init();
    }
    void init(){
        ((MaterialButton)findViewById(R.id.team_create_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date=new Date();
                post=new Post(((EditText)findViewById(R.id.team_create_title)).getText().toString(),
                        ((EditText)findViewById(R.id.team_create_contents)).getText().toString(),
                        (date.getYear()+1900)+"."+(date.getMonth()+1)+"."+date.getDate(),
                        ((EditText)findViewById(R.id.team_create_openchat)).getText().toString(),
                        Integer.parseInt(((EditText)findViewById(R.id.team_create_count)).getText().toString()),
                        ((EditText)findViewById(R.id.team_create_timeplace)).getText().toString(),
                        TeamFragment.getUserName());
                Intent intent=new Intent();
                intent.putExtra("post",post);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}