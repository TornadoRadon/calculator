package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {

    lateinit var mul: Chip
    lateinit var div: Chip
    lateinit var sub: Chip
    lateinit var add: Chip
    lateinit var seek1: SeekBar
    lateinit var seek2: SeekBar
    lateinit var result: TextView
    lateinit var arg1: TextView
    lateinit var arg2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mul = findViewById<Chip>(R.id.chip5)
        div = findViewById<Chip>(R.id.chip6)
        sub = findViewById<Chip>(R.id.chip7)
        add = findViewById<Chip>(R.id.chip8)
        seek1 = findViewById<SeekBar>(R.id.seekBar)
        seek2 = findViewById<SeekBar>(R.id.seekBar2)
        result = findViewById<TextView>(R.id.result)
        arg1 = findViewById<TextView>(R.id.textView3)
        arg2 = findViewById<TextView>(R.id.textView4)

        mul.setOnClickListener { solve(it) }
        div.setOnClickListener { solve(it) }
        sub.setOnClickListener { solve(it) }
        add.setOnClickListener { solve(it) }

        seek1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                arg1.text = i.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        seek2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                arg2.text = i.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

    }

    fun solve(v: View) {
        var x:Double = seek1.progress.toDouble()
        var y:Double = seek2.progress.toDouble()
        when (v) {
            mul -> result.text = (x * y).toString()
            div -> result.text = (x / y).toString()
            add -> result.text = (x + y).toString()
            sub -> result.text = (x - y).toString()
        }

    }
}