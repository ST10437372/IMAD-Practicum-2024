package com.st10437372.imadpracticum2024

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.st10437372.imadpracticum2024.databinding.ActivityMainBinding

data class ScreenTimeEntry(val date: String, val morning: Int, val afternoon: Int, val notes: String) : java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val screenTimeData = mutableListOf<ScreenTimeEntry>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, screenTimeData.map { it.toString() })
        binding.listView.adapter = adapter

        binding.buttonAdd.setOnClickListener {
            val date = binding.editTextDate.text.toString()
            val morningTime = binding.editTextMorningScreenTime.text.toString()
            val afternoonTime = binding.editTextAfternoonScreenTime.text.toString()
            val notes = binding.editTextNotes.text.toString()

            if (date.isNotEmpty() && morningTime.isNotEmpty() && afternoonTime.isNotEmpty()) {
                try {
                    val morningScreenTime = morningTime.toInt()
                    val afternoonScreenTime = afternoonTime.toInt()
                    screenTimeData.add(ScreenTimeEntry(date, morningScreenTime, afternoonScreenTime, notes))
                    adapter.notifyDataSetChanged()
                    binding.editTextDate.text.clear()
                    binding.editTextMorningScreenTime.text.clear()
                    binding.editTextAfternoonScreenTime.text.clear()
                    binding.editTextNotes.text.clear()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Please enter valid numbers for temperature", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonClear.setOnClickListener {
            screenTimeData.clear()
            adapter.notifyDataSetChanged()
        }

        binding.buttonDetails.setOnClickListener {
            val intent = Intent(this, DetailViewActivity::class.java)
            intent.putExtra("data", ArrayList(screenTimeData))
            startActivity(intent)
        }
    }
}
