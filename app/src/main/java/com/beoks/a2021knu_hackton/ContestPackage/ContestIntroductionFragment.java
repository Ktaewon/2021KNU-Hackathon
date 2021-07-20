package com.beoks.a2021knu_hackton.ContestPackage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.R;

public class ContestIntroductionFragment extends Fragment {
    Contest contest;
    public ContestIntroductionFragment(Contest contest){
        this.contest=contest;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_contest_introduction, container, false);
        ImageView imageView=(ImageView)viewGroup.findViewById(R.id.content_image);
        imageView.setImageBitmap(contest.getImage());
        ((TextView)viewGroup.findViewById(R.id.content_textview)).setText(contest.content);
        return viewGroup;
    }
}