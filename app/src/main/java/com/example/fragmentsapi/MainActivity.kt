package com.example.fragmentsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag(MainFragment.TAG) == null) {
            supportFragmentManager.beginTransaction().run{
                val fragment = MainFragment.newInstance()
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, fragment, MainFragment.TAG)
                addToBackStack(MainFragment.TAG)
                commit()
            }
        }

    }
}
