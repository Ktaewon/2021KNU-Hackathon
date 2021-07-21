package com.beoks.a2021knu_hackton.StudyPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.beoks.a2021knu_hackton.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainStudyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_study);
        setStudyPostButton();
        makeStudyListView();
    }

    void makeStudyListView(){
        ListView listview ;
//        StudyListAdapter adapter;
//        // Adapter 생성
//        adapter = new StudyListAdapter() ;
//
//        // 리스트뷰 참조 및 Adapter달기
//        listview = (ListView) findViewById(R.id.study_list);
//        listview.setAdapter(adapter);
//
//        // 임시 데이터 추가
//        adapter.addItem("코틀린 공부하실래요?","2021-7-23");
//        adapter.addItem("NodeJs, React로 웹서비스 공부해볼사람","2021-7-28");
//        adapter.addItem("AI 및 빅데이터 스터디 팀원모집","2021-7-30");

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