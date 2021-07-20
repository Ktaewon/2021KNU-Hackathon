package com.beoks.a2021knu_hackton.ContestPackage;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.Post;
import com.beoks.a2021knu_hackton.R;

import java.util.ArrayList;


public class TeamFragment extends Fragment {
    Contest contest;
    public TeamFragment(Contest contest) {
        // Required empty public constructor
        this.contest=contest;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup=(ViewGroup)inflater.inflate(R.layout.fragment_team, container, false);
        if(contest.post.size()!=0){
            ((TextView)viewGroup.findViewById(R.id.empty_textview)).setVisibility(View.GONE);
            setListView(viewGroup);
        }
        return viewGroup;
    }
    void setListView(ViewGroup view){
        ListView listView=(ListView)view.findViewById(R.id.team_listview);
        TeamAdapter teamAdapter=new TeamAdapter(getContext(),contest.post);
        listView.setAdapter(teamAdapter);

    }
    class TeamAdapter extends BaseAdapter{
        ArrayList<Post> posts;
        Context context;
        LayoutInflater layoutInflater;
        public TeamAdapter(Context context, ArrayList<Post> posts){
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
            }
            return view;
        }
    }
}