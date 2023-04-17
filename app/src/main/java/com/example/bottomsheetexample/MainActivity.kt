package com.example.bottomsheetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bottomsheetexample.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


      setupBottomSheet()

        binding.button.setOnClickListener {
            bottomSheetDialog.show()

        }
    }

    private fun setupBottomSheet(){
         bottomSheetDialog = BottomSheetDialog(this)
        val contentView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        bottomSheetDialog.setContentView(contentView)
        val editText = contentView.findViewById<EditText>(R.id.odometerValue)
        val btnSubmit = contentView.findViewById<Button>(R.id.submitButton)

        btnSubmit.setOnClickListener {
            val odometerValue = editText.text.toString()
            Toast.makeText(this, odometerValue, Toast.LENGTH_SHORT).show()

            bottomSheetDialog.dismiss()
        }



        bottomSheetDialog.behavior.apply {
            isDraggable = true
            state = BottomSheetBehavior.STATE_EXPANDED
            peekHeight = 500
            isHideable = false
        }
    }
}