package com.example.thuexe

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var searchText: EditText
    private lateinit var imageBrand: ImageView
    private lateinit var avatarCustomer: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchText = findViewById(R.id.searchText)
        var temp = arrayOf<String>("nextPage", "aaa", "new")
        searchText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val text: String = searchText.text.toString()
                for(i in temp.indices){
                    if( text?.equals(temp[i])){
                        val intent = Intent(this@MainActivity, carsActivity::class.java)
                        startActivity(intent)
                    }
                }
                return@OnKeyListener true
            }
            false
        })

        imageBrand = findViewById(R.id.imageBrandAudi)

        imageBrand.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, carsActivity::class.java)
            startActivity(intent)
        })

        avatarCustomer = findViewById(R.id.avatarCustomer)

        avatarCustomer.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, personalSettingActivity::class.java)
            startActivity(intent)
//            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        })
    }
}