package com.example.pum1


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun click(view: View?){
        val userInputField: EditText = findViewById(R.id.userInput)
        if(validateUserInput()){
            val userInput = userInputField.text.toString().toDouble()
            val result = (userInput * 1.8) + 32
            setText(String.format(Locale.US ,"%.2f", result))
        }else{
            setText("Podaj poprawną wartość")
        }

    }

    private fun validateUserInput(): Boolean {
        return !findViewById<EditText>(R.id.userInput).text.isNullOrBlank()
    }

    private fun setText(result: String){
        val textElement = findViewById<TextView>(R.id.textView)
        textElement.text = result;
    }
}