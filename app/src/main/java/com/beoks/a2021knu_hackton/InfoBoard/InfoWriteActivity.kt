package com.beoks.a2021knu_hackton.InfoBoard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.beoks.a2021knu_hackton.R
import com.google.android.material.button.MaterialButton
import java.util.*

class InfoWriteActivity : AppCompatActivity() {
    public val items= arrayOf("스터디","프로젝트","로드맵","공모전")
    private var title_editText : EditText?=null
    private var descriptionEditText : EditText?=null
    private var openChatEditText : EditText?=null
    private var spinner : Spinner?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_write)
        setView()
        setSpinner()
    }

    private fun setView(){
        title_editText=findViewById<EditText>(R.id.team_create_title)
        descriptionEditText=findViewById<EditText>(R.id.team_create_contents)
        openChatEditText=findViewById<EditText>(R.id.team_create_openchat)
        spinner=findViewById<Spinner>(R.id.spinner)

        findViewById<MaterialButton>(R.id.team_create_button).setOnClickListener(View.OnClickListener {
            val date=Date();
            var infoData=InfoData(title=title_editText!!.text.toString(),
                date=(date.year+1900).toString()+"."+(date.month+1)+"."+date.date.toString(),
                content = descriptionEditText!!.text.toString(),
                type = items[spinner!!.selectedItemPosition],writer = openChatEditText!!.text.toString())

            var intent=Intent()
            intent.putExtra("infoData",infoData)
            setResult(RESULT_OK,intent)
            finish()
        })

    }
    fun setSpinner() {
        val adapter=ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,items)
        spinner!!.adapter=adapter
    }
}