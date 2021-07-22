package com.beoks.a2021knu_hackton.ContestPackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.Post;
import com.beoks.a2021knu_hackton.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class TeamFragment extends Fragment {
    Contest contest;
    ViewGroup viewGroup;
    int lastCalledPostIndex;
    public TeamFragment(Contest contest) {
        // Required empty public constructor
        this.contest=contest;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewGroup=(ViewGroup)inflater.inflate(R.layout.fragment_team, container, false);
        if(contest.post.size()!=0){
            ((TextView)viewGroup.findViewById(R.id.empty_textview)).setVisibility(View.GONE);
            setListView(viewGroup);
        }
        setFloatingButton(viewGroup);
        return viewGroup;
    }
    void setListView(ViewGroup view){
        ListView listView=(ListView)view.findViewById(R.id.team_listview);
        TeamAdapter teamAdapter=new TeamAdapter(getContext(),contest.post);
        listView.setAdapter(teamAdapter);

    }
    class TeamAdapter extends BaseAdapter{
        List<Post> posts;
        Context context;
        LayoutInflater layoutInflater;
        public TeamAdapter(Context context, List<Post> posts){
            this.posts=posts;
            this.context=context;
            this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return posts.size();
        }

        @Override
        public Object getItem(int i) {
            return posts.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=layoutInflater.inflate(R.layout.team_view,null);
                ((TextView)view.findViewById(R.id.team_title)).setText(posts.get(i).title);
                ((TextView)view.findViewById(R.id.team_date)).setText(posts.get(i).date);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getContext(),TeamInfoActivity.class);
                        intent.putExtra("post",posts.get(i));
                        lastCalledPostIndex=i;
                        intent.putExtra("userName",getUserName());
                        startActivityForResult(intent,222);
                    }
                });

                TextView recruit_view=(TextView)view.findViewById(R.id.team_view_recruit_textview);
                if(posts.get(i).isRecruit){
                    recruit_view.setText("모집중");
                    recruit_view.setBackgroundColor(getResources().getColor(R.color.theme));
                }
                else{
                    recruit_view.setText("모집완료");
                    recruit_view.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
            return view;
        }
    }
    public static String getUserName(){
        return "ljs";
    }
    void setFloatingButton(ViewGroup viewGroup){
        ((FloatingActionButton)viewGroup.findViewById(R.id.floating_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),TeamCreateActivity.class);
                startActivityForResult(intent,111);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111 && resultCode==RESULT_OK){
            Post post=(Post)data.getSerializableExtra("post");
            contest.post.add(post);
            setListView(viewGroup);
        }
        if(requestCode==222){
            if(resultCode==TeamInfoActivity.CHANGE_POST){
                contest.post.set(lastCalledPostIndex,(Post)data.getSerializableExtra("post"));
//                Log.d("lastCalledPost",lastCalledPost.isRecruit+"");
//                Log.d("lastCalledPost",contest.post.get(0).isRecruit+"");
            }
            else if(resultCode==TeamInfoActivity.DELETE){
                contest.post.remove(lastCalledPostIndex);
            }
            setListView(viewGroup);
        }
    }
}