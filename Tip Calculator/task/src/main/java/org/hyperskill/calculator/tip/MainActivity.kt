package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    var discount = 0
    var X:Double = 0.0
    lateinit var textView: TextView
    lateinit var slider: Slider
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.text_view)
        editText = findViewById<EditText>(R.id.edit_text)
        slider = findViewById<Slider>(R.id.slider)


        editText.doOnTextChanged { text, start, before, count -> updateTextView() }
        slider.addOnChangeListener { slider, value, fromUser -> updateTextView() }

    }


    fun updateTextView(){
        discount = slider.value.toInt()
        val amt = editText.text.toString()
        if (amt.isNotEmpty()){
            X = amt.toDouble()
            val tip = (X*discount)*0.01
            textView.text = "Tip amount: "+"%.2f".format(tip)
        }else{
            textView.text = ""
        }
    }
}