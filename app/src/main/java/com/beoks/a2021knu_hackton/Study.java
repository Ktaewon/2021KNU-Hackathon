package com.beoks.a2021knu_hackton;

import com.beoks.a2021knu_hackton.InfoBoard.InfoData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Study{
    public void main(){
        InfoData.Companion.getDataFromFB(new InfoData.Companion.Listener() {
            @Override
            public void onGetDataListener(@NotNull ArrayList<InfoData> infoDataArrayList) {

            }
        });
    }
}
