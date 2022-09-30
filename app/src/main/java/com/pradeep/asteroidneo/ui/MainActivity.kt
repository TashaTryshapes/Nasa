package com.pradeep.asteroidneo.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradeep.asteroidneo.R
import com.pradeep.asteroidneo.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        txtStartingDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePicker = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->
                val finalDateStarting = "$year-$monthOfYear-$dayOfMonth"
                txtStartingDate.text = finalDateStarting.toString()

            }, year, month, day)

            datePicker.show()
        }

        txtEndDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerEnd = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->
                val finalDateStarting = "$year-$monthOfYear-$dayOfMonth"
                txtEndDate.text = finalDateStarting.toString()

            }, year, month, day)
            datePickerEnd.show()
        }

        btnSubmit.setOnClickListener {
            val startingDate = txtStartingDate.text.toString()
            val endDate = txtEndDate.text.toString()
            when {
                startingDate.isNotEmpty() && endDate.isNotEmpty() -> {
                    viewModel.getNasaList(startingDate, endDate)
                }
                startingDate.isEmpty() -> {
                    Toast.makeText(this, "Starting Date is Missing", Toast.LENGTH_SHORT).show()
                }
                startingDate.isEmpty() -> {
                    Toast.makeText(this, "End Date is Missing", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = viewModel.adapterNasa
    }
}