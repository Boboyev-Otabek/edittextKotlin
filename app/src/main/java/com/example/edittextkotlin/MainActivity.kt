package com.example.edittextkotlin

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var edittext:EditText
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {

        edittext=findViewById(R.id.edittext)
        textView=findViewById(R.id.text)

        edittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                Toast.makeText(applicationContext, editable, Toast.LENGTH_SHORT).show()
                if (editable.length < 8) {
                    textView.text = "Belgilar soni 8 ta dan ko'p bo'lishi kerak"
                    textView.setTextColor(Color.RED)
                } else {
                    textView.text = "Raxmat"
                    textView.setTextColor(Color.GREEN)
                }
            }
        })



    }
     class mykeylister : View.OnKeyListener {
         lateinit var edittext:EditText
         lateinit var context: Context
         lateinit var textView: TextView
        override fun onKey(view: View, keycode: Int, keyEvent: KeyEvent): Boolean {
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keycode == KeyEvent.KEYCODE_ENTER) {
                Toast.makeText (context, edittext.getText(), Toast.LENGTH_SHORT).show()
                textView.setText("Assalom " + edittext.getText())
                return true
            }
            return false
        }
    }
}