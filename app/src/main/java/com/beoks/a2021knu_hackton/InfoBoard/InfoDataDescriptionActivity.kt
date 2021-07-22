package com.beoks.a2021knu_hackton.InfoBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.beoks.a2021knu_hackton.R

class InfoDataDescriptionActivity : AppCompatActivity() {
    var infoData: InfoData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_data_description)
        init()
    }

    fun init() {
        getData()
        setHead()
        setDescription()
    }
    fun getData(){
        infoData = intent.getSerializableExtra("InfoData") as InfoData
    }

    fun setHead() {
        val layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.info_main_list_content, null)
        (view.findViewById<View>(R.id.info_main_list_content_title) as TextView).text = infoData!!.title
        (view.findViewById<View>(R.id.info_main_list_content_kind) as TextView).text = infoData!!.type
        (view.findViewById<View>(R.id.info_main_list_content_date) as TextView).text = infoData!!.date
        (findViewById<View>(R.id.info_description_content_layout) as LinearLayout).addView(view)
    }

    fun setDescription() {
        (findViewById<View>(R.id.info_description_content) as TextView).text = infoData!!.content
    }
}