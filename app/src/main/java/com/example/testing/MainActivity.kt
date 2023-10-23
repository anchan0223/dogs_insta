package com.example.testing

import android.hardware.biometrics.BiometricManager.Strings
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    private lateinit var dogsList: MutableList<String>
    private lateinit var recyclerViewDog: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewDog = findViewById(R.id.dog_RecyclerView)
        dogsList = mutableListOf()



        // Move the getDogImageURL function here
        getDogImageURL()
        Log.d("petImageURL", "pet image URL set")


    }

    private fun getDogImageURL() {

        val client = AsyncHttpClient()
        client["https://dog.ceo/api/breeds/image/random/10", object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {

                val dogImageArray = json.jsonObject.getJSONArray("message")

                for (i in 0 until dogImageArray.length()) {
                    dogsList.add(dogImageArray.getString(i))

                }
                val userNames = listOf(
                    getString(R.string.user_name_image1),
                    getString(R.string.user_name_image2),
                    getString(R.string.user_name_image3),
                    getString(R.string.user_name_image4),
                    getString(R.string.user_name_image5),
                    getString(R.string.user_name_image6),
                    getString(R.string.user_name_image7),
                    getString(R.string.user_name_image8),
                    getString(R.string.user_name_image9),
                    getString(R.string.user_name_image10),

                )

                val Likes = listOf(
                    getString(R.string.like_count_image1),
                    getString(R.string.like_count_image2),
                    getString(R.string.like_count_image3),
                    getString(R.string.like_count_image4),
                    getString(R.string.like_count_image5),
                    getString(R.string.like_count_image6),
                    getString(R.string.like_count_image7),
                    getString(R.string.like_count_image8),
                    getString(R.string.like_count_image9),
                    getString(R.string.like_count_image10),

                    )

                val adapter = Adapter(dogsList,userNames,Likes)
                recyclerViewDog.adapter = adapter
                recyclerViewDog.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Dog Error", errorResponse)
            }
        }]
    }


    }


