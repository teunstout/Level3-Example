package com.example.remindersapp

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
    var reminders = arrayListOf<Reminder>()
    var reminderAdapter = ReminderAdapter(reminders)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
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
        val intent = Intent(this, addActivity::class.java)
        startActivityForResult(intent, ADD_REMINDER_REQUEST_CODE)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
