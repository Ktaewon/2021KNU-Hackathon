package com.beoks.a2021knu_hackton;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.beoks.a2021knu_hackton.ContestPackage.ContestInformationActivity;
import com.beoks.a2021knu_hackton.ContestPackage.ContestMainActivity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardView extends LinearLayout {
    private Contest contest;
    private Context context;
    public CardView(Context context,Contest contest) {
        super(context);
        this.contest =contest;
        this.context=context;
        init();
    }

    public CardView(Context context, @Nullable AttributeSet attrs,Contest content) {
        super(context, attrs);
        this.contest = content;
        init();
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr,Contest content) {
        super(context, attrs, defStyleAttr);
        this.contest = content;
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.card_view,this);
        ImageView imageView=(ImageView)findViewById(R.id.content_image);
        imageView.setImageBitmap(contest.getImage());
        TextView textView=(TextView)findViewById(R.id.content_title);
        textView.setText(contest.title);
        TextView textView1=(TextView)findViewById(R.id.content_view_count);
        textView1.setText(contest.viewCount+"");
        setClick();
        setDate();
    }
    private void setClick(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ContestInformationActivity.class);
                intent.putExtra("contest",contest);
                getContext().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }
    private void setDate(){
        long leftDate=contest.getDDay();
        if(leftDate>0){
            ((TextView)findViewById(R.id.content_d_day_textview)).setText("D-"+leftDate);
        }
        else if(leftDate==0){
            ((TextView)findViewById(R.id.content_d_day_textview)).setText("D-Day");
        }
        else{
            ((TextView)findViewById(R.id.content_d_day_textview)).setText("마감");
        }
    }

}
