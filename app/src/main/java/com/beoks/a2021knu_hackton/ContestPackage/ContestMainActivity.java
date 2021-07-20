package com.beoks.a2021knu_hackton.ContestPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.beoks.a2021knu_hackton.CardView;
import com.beoks.a2021knu_hackton.Contest;
import com.beoks.a2021knu_hackton.R;

import java.util.ArrayList;

public class ContestMainActivity extends AppCompatActivity {
    ArrayList<Contest> contestArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_main);
        init();
    }
    private void init(){
        //TODO get contest from firebase database
        //test
        contestArrayList=new ArrayList<Contest>();
        contestArrayList.add(Contest.getSample());
        contestArrayList.add(Contest.getSample());
        contestArrayList.add(Contest.getSample());
        contestArrayList.add(Contest.getSample());
        contestArrayList.add(Contest.getSample());
        ContestAdapter contestAdapter=new ContestAdapter(getApplicationContext(),contestArrayList);
        GridView gridView=(GridView)findViewById(R.id.contest_main_gridview);
        gridView.setAdapter(contestAdapter);
    }
}
class ContestAdapter extends BaseAdapter{
    ArrayList<Contest> contestArrayList;
    Context context;
    LayoutInflater layoutInflater;
    public ContestAdapter(Context context, ArrayList<Contest> contestArrayList){
        this.contestArrayList=contestArrayList;
        this.context=context;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return contestArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return contestArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view= new CardView(context, contestArrayList.get(i));
        }
        return view;
    }
}