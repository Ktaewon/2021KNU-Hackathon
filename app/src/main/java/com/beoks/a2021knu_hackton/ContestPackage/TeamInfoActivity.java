package com.beoks.a2021knu_hackton.ContestPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.beoks.a2021knu_hackton.Post;
import com.beoks.a2021knu_hackton.R;

public class TeamInfoActivity extends AppCompatActivity {
    Post post;
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
        ((TextView)findViewById(R.id.team_info_openchat)).setText(post.openChatLink);
    }
}