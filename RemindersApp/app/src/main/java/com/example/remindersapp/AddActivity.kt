package com.example.remindersapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // back button

        floatingActionButton.setOnClickListener { onSaveClick() }
    }

    /**
     * Give the result back to the intent from main screen
     */
    private fun onSaveClick() {
        if (etAddReminder.text.toString().isNotBlank()) {
            val reminder = Reminder(etAddReminder.text.toString())
            // intent to give back the information and finish this intent
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The reminder cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
}

