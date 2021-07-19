package com.beoks.a2021knu_hackton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * 공모전, 스터디 선택가능한 메인화면 액티비티
 * 얼마남지 않은 공모전과 모집중인 스터디 리스트를 보여줌
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}