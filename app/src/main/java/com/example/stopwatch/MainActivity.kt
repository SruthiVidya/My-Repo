package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import com.example.stopwatch.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access the chronometer from XML file
        val meter = findViewById<Chronometer>(R.id.c_meter)

        //access the button using id
        val btn = findViewById<Button>(R.id.btn)
        btn?.setOnClickListener(object : View.OnClickListener {

            var isWorking = false

            override fun onClick(v: View) {
                if (!isWorking) {
                    meter.start()
                    isWorking = true
                } else {
                    meter.stop()
                    isWorking = false
                }

                btn.setText(if (isWorking) R.string.start else R.string.stop)

                Toast.makeText(this@MainActivity, getString(
                        if (isWorking)
                            R.string.working
                        else
                            R.string.stopped),
                        Toast.LENGTH_SHORT).show()
            }
        })
    }
}
