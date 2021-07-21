package com.beoks.a2021knu_hackton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.beoks.a2021knu_hackton.CardView;
import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.ContestPackage.ContestMainActivity;
import com.beoks.a2021knu_hackton.InfoBoard.InfoMainActivity;
import com.beoks.a2021knu_hackton.R;
import com.beoks.a2021knu_hackton.StudyPackage.MainStudyActivity;

/**
 * 공모전, 스터디 선택가능한 메인화면 액티비티
 * 얼마남지 않은 공모전과 모집중인 스터디 리스트를 보여줌
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contestTesting();
        setContestButton();
        setStduyButton();
        setMyPageButton();
    }
    void contestTesting(){
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.main_competition_layout);
        linearLayout.addView(new CardView(getApplicationContext(), Contest.getSample()));
        linearLayout.addView(new CardView(getApplicationContext(), Contest.getSample()));
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