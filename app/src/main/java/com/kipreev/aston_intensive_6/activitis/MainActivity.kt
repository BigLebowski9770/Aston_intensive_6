package com.kipreev.aston_intensive_6.activitis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kipreev.aston_intensive_6.R
import com.kipreev.aston_intensive_6.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListFragment())
            .commit()
    }
}