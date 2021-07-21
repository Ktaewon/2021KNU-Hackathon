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
import com.beoks.a2021knu_hackton.InfoBoard.InfoData.Companion.sample
import com.beoks.a2021knu_hackton.R
import java.util.*

class InfoMainActivity : AppCompatActivity() {

    var infoDataArrayList: ArrayList<InfoData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_main)
        infoBoardData
        setListView()
    }

    //get sample data
    val infoBoardData: Unit
        get() {
            //get sample data
            infoDataArrayList = ArrayList()
            infoDataArrayList!!.add(sample)
            infoDataArrayList!!.add(sample)
            infoDataArrayList!!.add(sample)
            infoDataArrayList!!.add(sample)
        }

    fun setListView() {
        (findViewById<View>(R.id.info_main_listview) as ListView).adapter = InfoAdapter(applicationContext)
    }

    internal inner class InfoAdapter(context: Context?) : BaseAdapter() {
        var inflater: LayoutInflater
        override fun getCount(): Int {
            return infoDataArrayList!!.size
        }

        override fun getItem(i: Int): Any {
            return infoDataArrayList!![i]
        }

        override fun getItemId(i: Int): Long {
            return i.toLong()
        }

        override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view
            if (view == null) {
                view = inflater.inflate(R.layout.info_main_list_content, null)
                (view.findViewById<View>(R.id.info_main_list_content_title) as TextView).text = infoDataArrayList!![i].title
                (view.findViewById<View>(R.id.info_main_list_content_kind) as TextView).text = infoDataArrayList!![i].kind
                (view.findViewById<View>(R.id.info_main_list_content_date) as TextView).text = infoDataArrayList!![i].date
                view.setOnClickListener {
                    val intent = Intent(applicationContext, InfoDataDescriptionActivity::class.java)
                    intent.putExtra("InfoData", infoDataArrayList!![i])
                    startActivity(intent)
                }
            }
            return view!!
        }

        init {
            inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
    }
}