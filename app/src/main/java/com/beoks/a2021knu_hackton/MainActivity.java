package com.beoks.a2021knu_hackton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.beoks.a2021knu_hackton.CardView;
import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.ContestPackage.ContestMainActivity;
import com.beoks.a2021knu_hackton.InfoBoard.InfoMainActivity;
import com.beoks.a2021knu_hackton.R;
import com.beoks.a2021knu_hackton.StudyPackage.MainStudyActivity;
import com.beoks.a2021knu_hackton.StudyPackage.StudyListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
//import com.beoks.a2021knu_hackton.StudyPackage.StudyListAdapter;

/**
 * 공모전, 스터디 선택가능한 메인화면 액티비티
 * 얼마남지 않은 공모전과 모집중인 스터디 리스트를 보여줌
 */
public class MainActivity extends AppCompatActivity {
    ListView listview ;
//    StudyListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    void init(){
        setContentView(R.layout.activity_main);
        contestTesting();
        setContestButton();
        setStduyButton();
        setMyPageButton();
        makeStudyListView();
    }
    void contestTesting(){
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.main_competition_layout);
        Contest.getContestsFromFB(new Contest.Listener() {
            @Override
            public void onDataGetListener(ArrayList<Contest> contests) {
                ((ProgressBar)findViewById(R.id.progressBar)).setVisibility(View.GONE);
                linearLayout.addView(new CardView(getApplicationContext(), contests.get(0)));
                linearLayout.addView(new CardView(getApplicationContext(), contests.get(1)));
            }
        });
    }

    void makeStudyListView(){

        // Adapter 생성
        StudyListAdapter adapter = new StudyListAdapter() ;
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.main_page_studyview);
        listview.setAdapter(adapter);

        //임시 데이터 추가
        adapter.addItem("코틀린 공부하실래요?","2021-7-23");
        adapter.addItem("NodeJs, React로 웹서비스 공부해볼사람","2021-7-28");
        System.out.println("...."+adapter.getCount());

    }
    void setContestButton(){
        ((ImageButton)findViewById(R.id.comeptition_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ContestMainActivity.class);
                startActivity(intent);
            }
        });
    }
    void setMyPageButton(){
        ((ImageButton)findViewById(R.id.my_page_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), InfoMainActivity.class);
                startActivity(intent);
            }
        });
    }

    void setStduyButton(){
        ((ImageButton)findViewById(R.id.study_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainStudyActivity.class);
                startActivity(intent);
            }
        });
    }

}