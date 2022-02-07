package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    // El signo de interrogación indica que la variable podría ser null
    var tts:TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this,this)

        findViewById<Button>(R.id.btnPlay).setOnClickListener{speak()}

    }

    private fun speak(){
        var message:String = findViewById<TextView>(R.id.tvStatus).text.toString()
        // La doble exclamación indica que se puede invocar cualqueir método y que no será null
        tts!!.speak(message,TextToSpeech.QUEUE_FLUSH,null,"")

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.tvStatus).text = "Welcome to the Kotlin World !!!"
            tts!!.setLanguage(Locale.US)
        } else {
            findViewById<TextView>(R.id.tvStatus).text = "No disponible"
        }
    }
}