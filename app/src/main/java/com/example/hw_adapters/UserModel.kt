package com.example.hw_adapters

import androidx.appcompat.app.AppCompatActivity

class UserModel(val name:String, val lastname: String, val country: String, val city: String, val age: Int, val image: Int) {



    companion object Factory {
        fun build(compatActivity: AppCompatActivity): UserModel {
            val country = compatActivity.resources.getStringArray(R.array.countries)[(0..2).random()]
            val city =  when(country){
                "Canada" -> compatActivity.resources.getStringArray(R.array.cities_can)[(0..9).random()]
                "Australia" -> compatActivity.resources.getStringArray(R.array.cities_aus)[(0..9).random()]
                "United Kingdom" -> compatActivity.resources.getStringArray(R.array.cities_uk)[(0..9).random()]
                else -> compatActivity.resources.getStringArray(R.array.cities_can)[(0..9).random()]
            }
            val image = intArrayOf(R.drawable.av_f1, R.drawable.av_f2, R.drawable.av_f3, R.drawable.av_m1, R.drawable.av_m2, R.drawable.av_m3).random()
            val name = compatActivity.resources.getStringArray(R.array.list_names)[(0..9).random()]
            val lastname = compatActivity.resources.getStringArray(R.array.list_lastnames)[(0..9).random()]
            val age = (18..50).random()
            return UserModel(name, lastname, country, city, age, image)

        }
    }
}