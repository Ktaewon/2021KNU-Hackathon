package com.beoks.a2021knu_hackton.InfoBoard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.beoks.a2021knu_hackton.InfoBoard.InfoData.Companion.getDataFromFB
import com.beoks.a2021knu_hackton.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InfoMainActivity : AppCompatActivity() {
    var adapter : InfoAdapter?=null
    var infoDataArrayList : ArrayList<InfoData?>? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_main)
        getInfoData()
        setButton()
        setTitle("정보 게시판")
    }


    fun getInfoData() {
        getDataFromFB(object : InfoData.Companion.Listener {
            override fun onGetDataListener(infoDataArrayList1: java.util.ArrayList<InfoData?>) {
                infoDataArrayList=infoDataArrayList1
                adapter=InfoAdapter(applicationContext)
                (findViewById<ListView>(R.id.info_main_listview)).adapter=adapter
            }
        })
    }
    fun setButton(){
        var button=findViewById<FloatingActionButton>(R.id.floating_button);
        button.setOnClickListener(View.OnClickListener {
            var intent=Intent(applicationContext,InfoWriteActivity::class.java);
            startActivityForResult(intent,111)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==111){
            if (resultCode== RESULT_OK){
                infoDataArrayList!!.add(data!!.getSerializableExtra("infoData") as InfoData)
                adapter!!.notifyDataSetChanged()
            }
        }
    }
    inner class InfoAdapter(context: Context?) : BaseAdapter() {
        var inflater: LayoutInflater

        override fun getCount(): Int {
            return infoDataArrayList!!.size
        }

        override fun getItem(i: Int): Any {
            return infoDataArrayList!![i]!!
        }

        override fun getItemId(i: Int): Long {
            return i.toLong()
        }

        override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view
            view = inflater.inflate(R.layout.info_main_list_content, null)
            (view.findViewById<View>(R.id.info_main_list_content_title) as TextView).text = infoDataArrayList!![i]!!.title
            (view.findViewById<View>(R.id.info_main_list_content_kind) as TextView).text = infoDataArrayList!![i]!!.type
            (view.findViewById<View>(R.id.info_main_list_content_date) as TextView).text = infoDataArrayList!![i]!!.date
            view.setOnClickListener {
                val intent = Intent(applicationContext, InfoDataDescriptionActivity::class.java)
                intent.putExtra("InfoData", infoDataArrayList!![i])
                startActivity(intent)
            }
            return view!!
        }

        init {
            inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
    }
}