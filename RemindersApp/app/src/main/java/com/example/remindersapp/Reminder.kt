package com.example.remindersapp

data class Reminder(val name: String){
    companion object{
        val STANDERTREMINDERS = arrayOf(
            "Koken",
            "Stofzuigen",
            "Dokters afspraak"
        )
    }
}