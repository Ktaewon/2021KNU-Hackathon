package com.beoks.a2021knu_hackton.ContestPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.beoks.a2021knu_hackton.Post;
import com.beoks.a2021knu_hackton.R;

public class TeamInfoActivity extends AppCompatActivity {
    Post post;
    public static final int CHANGE_POST=1,DELETE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);
        init();
    }
    void init(){
        post=(Post)getIntent().getSerializableExtra("post");
        ((TextView)findViewById(R.id.team_info_title)).setText(post.title);
        ((TextView)findViewById(R.id.team_info_date)).setText(post.date);
        ((TextView)findViewById(R.id.team_info_member)).setText(post.max_count+"명");
        ((TextView)findViewById(R.id.team_info_timeplace)).setText(post.timeplace);
        ((TextView)findViewById(R.id.team_info_content)).setText(post.content);
        ((TextView)findViewById(R.id.team_info_openchat)).setText(post.link);
        String userName=getIntent().getStringExtra("userName");

        Button recruit_button=(Button)findViewById(R.id.team_info_recruit_button);
        Button delete_button=(Button)findViewById(R.id.team_info_delete_button);
        Button revise_button=(Button)findViewById(R.id.team_info_revise);

//      if(userName.equals(post.writer)){
        if(true){
            recruit_button.setText(post.isRecruit?"모집 종료":"모집 시작");
            recruit_button.setVisibility(View.VISIBLE);
            recruit_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    post.isRecruit=!post.isRecruit;
                    Intent intent=new Intent();
                    intent.putExtra("post",post);
                    setResult(CHANGE_POST,intent);
                    finish();
                }
            });
            delete_button.setVisibility(View.VISIBLE);
            delete_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setResult(DELETE);
                    finish();
                }
            });
            revise_button.setVisibility(View.VISIBLE);
            revise_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        else{
            recruit_button.setVisibility(View.GONE);
            delete_button.setVisibility(View.GONE);
            revise_button.setVisibility(View.GONE);
        }
    }
}