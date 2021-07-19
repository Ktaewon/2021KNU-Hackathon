package com.beoks.a2021knu_hackton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CardView extends LinearLayout {
    private Content content;
    public CardView(Context context) {
        super(context);
        this.content=content;
        init();
    }

    public CardView(Context context, @Nullable AttributeSet attrs,Content content) {
        super(context, attrs);
        this.content = content;
        init();
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr,Content content) {
        super(context, attrs, defStyleAttr);
        this.content = content;
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.card_view,this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ImageView imageView=(ImageView)findViewById(R.id.content_image);
        imageView.setImageBitmap(content.image);
        TextView textView=(TextView)findViewById(R.id.content_title);
        textView.setText(content.name);
        TextView textView1=(TextView)findViewById(R.id.content_view_count);
        textView1.setText(content.viewCount);
    }
}
