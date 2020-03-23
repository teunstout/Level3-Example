package com.example.remindersapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

val ADD_REMINDER_REQUEST_CODE = 100;

class MainActivity : AppCompatActivity() {
    private var reminders = arrayListOf<Reminder>()
    private var reminderAdapter = ReminderAdapter(reminders)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            startAddActivity()
        }

        // add all data to reminders
        for (i in Reminder.STANDERTREMINDERS){
            reminders.add(Reminder(i))
        }

        initViews()
    }

    private fun initViews() {
        rvReminder.layoutManager = StaggeredGridLayoutManager(1, 1) // gebruik een staggerd grid
        rvReminder.adapter = reminderAdapter // adapter recycle view is questionadapter
        // scheid de lijntjes doormiddel van een verticale lijn
        rvReminder.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun startAddActivity() {
        val intent = Intent(this, AddActivity::class.java)
        startActivityForResult(intent, ADD_REMINDER_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_REMINDER_REQUEST_CODE -> {
                    // kan beter zonder !!
                    val reminder = data!!.getParcelableExtra<Reminder>(EXTRA_REMINDER)
                    reminders.add(reminder)
                    reminderAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}
