package com.example.asynctaskexample

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        downloadText.setOnClickListener {
            val myTask = MyTask()
            myTask.execute("https://www.google.com/")
            //myTask.cancel(true)

        }
    }

    inner class MyTask : AsyncTask<String, Int, String>() {
        //runs on background thread
        override fun doInBackground(vararg params: String): String? {
            //if(!isCancelled){

            publishProgress(100)

            return getDataFromNetwork(params[0])
        }

        //runs on Main thread
        override fun onProgressUpdate(vararg progress: Int?) {
            //setProgress(progress[0])
        }

        //runs on Main thread
        override fun onPostExecute(result: String?) {
            text_data.text = result
        }
    }
}
