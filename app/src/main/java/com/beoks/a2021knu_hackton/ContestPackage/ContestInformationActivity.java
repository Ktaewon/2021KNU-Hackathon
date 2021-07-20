package com.beoks.a2021knu_hackton.ContestPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.R;
import com.google.android.material.tabs.TabLayout;

public class ContestInformationActivity extends FragmentActivity {
    ContestIntroductionFragment contestIntroductionFragment;
    TeamFragment teamFragment;
    TabLayout tabLayout;
    Contest contest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_information);
        init();
    }
    void init(){
        getContest();
        initHead();
        initTab();

    }
    void getContest(){
        contest=(Contest)getIntent().getSerializableExtra("contest");
    }
    void initHead(){
        ((ImageView)findViewById(R.id.contest_info_image)).setImageBitmap(contest.getImage());
        ((TextView)findViewById(R.id.contest_info_title)).setText(contest.title);
        ((TextView)findViewById(R.id.content_info_view_count)).setText(contest.viewCount+"");
        setDate();

    }
    void initTab(){
        contestIntroductionFragment=new ContestIntroductionFragment(contest);
        teamFragment=new TeamFragment(contest);
        getSupportFragmentManager().beginTransaction().add(R.id.container,contestIntroductionFragment).commit();
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("소개"));
        tabLayout.addTab(tabLayout.newTab().setText("팀원모집"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,contestIntroductionFragment).commit();
                }
                else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,teamFragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setDate(){
        long leftDate=contest.getDDay();
        if(leftDate>0){
            ((TextView)findViewById(R.id.content_info_d_day_textview)).setText("D-"+leftDate);
        }
        else if(leftDate==0){
            ((TextView)findViewById(R.id.content_info_d_day_textview)).setText("D-Day");
        }
        else{
            ((TextView)findViewById(R.id.content_info_d_day_textview)).setText("마감");
        }
    }
}