package br.edu.utfpr.usandociclodevida

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        Log.d("MainActivity", "onCreate executado")
    }
        override fun onStart() {
            super.onStart()
            Log.d("MainActivity", "onResume executado")
        }

        override fun onPause(){
            super.onPause()
            Log.d("MainActivity", "onPause executado")
        }

        override fun onRestart(){
            super.onRestart()
            Log.d("MainActivity", "onRestart executado")
        }

        override fun onStop(){
            super.onStop()
            Log.d("MainActivity", "onStop executado")
        }

        override fun onDestroy(){
            super.onDestroy()
            Log.d("MainActivity", "onDestroy executado")

    }
}