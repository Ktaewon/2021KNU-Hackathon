package com.beoks.a2021knu_hackton.InfoBoard

import android.util.Log
import com.beoks.a2021knu_hackton.Contest
import com.google.firebase.database.FirebaseDatabase
import java.io.Serializable

class InfoData(var title: String?=null, var date: String?=null, var content: String?=null, var type: String?=null, var writer: String?=null) : Serializable {

    companion object {
        val sample: InfoData
            get() = InfoData("프로젝트 협업 툴 모음",
                    "2021.07.23",
                    """예시 프로젝트나 스터디 할 때, 활용해보세요!

 1. Github
https://github.com/

 2. Slack
https://slack.com/intl/ko-kr/

 3. Trello
https://trello.com/

 4. 네이버 웍스
https://naver.worksmobile.com/""",
                    "스터디","https://open.kakao.com/ffff")
        interface Listener{
            fun onGetDataListener(infoDataArrayList: ArrayList<InfoData?>)
        }
        fun getDataFromFB(listener: Listener){
            var arrayList = java.util.ArrayList<InfoData?>()
            var database = FirebaseDatabase.getInstance()
            var myRef = database.getReference("info")
            myRef.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (dataSnapshot in task.result!!.children) {
                        arrayList.add(dataSnapshot.getValue(InfoData::class.java))
                    }
                    listener.onGetDataListener(arrayList)
                    Log.d("firebase_contest", "Success")
                } else {
                    Log.d("firebase_contest", "fail")
                }
            }
        }
    }
}