package com.st10437372.imadpracticum2024

import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.st10437372.imadpracticum2024.databinding.ActivityDetailViewBinding

class DetailViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val screenTimeData = intent.getSerializableExtra("data") as ArrayList<ScreenTimeEntry>

        var totalScreenTime = 0
        for (entry in screenTimeData) {
            totalScreenTime += entry.morning + entry.afternoon

            val tableRow = TableRow(this)

            val dateTextView = TextView(this)
            dateTextView.text = entry.date
            tableRow.addView(dateTextView)

            val morningTextView = TextView(this)
            morningTextView.text = entry.morning.toString()
            tableRow.addView(morningTextView)

            val afternoonTextView = TextView(this)
            afternoonTextView.text = entry.afternoon.toString()
            tableRow.addView(afternoonTextView)

            val notesTextView = TextView(this)
            notesTextView.text = entry.notes
            tableRow.addView(notesTextView)

            binding.tableData.addView(tableRow)
        }

        val averageScreenTime = if (screenTimeData.isNotEmpty()) totalScreenTime / screenTimeData.size else 0
        binding.averageScreenTime.text = "Average Screen Time: $averageScreenTime"

        binding.buttonBack.setOnClickListener {
            finish()
        }
    }
}
