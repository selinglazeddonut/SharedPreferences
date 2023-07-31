package com.example.kimbu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kimbu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val sharedPref by lazy { getSharedPreferences("myPrefs", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.yasiniyazEditText.setOnClickListener {
            binding.yasTextView.text = binding.yasiniyazEditText.text.toString()
        }

        binding.silButton.setOnClickListener {
            binding.yasiniyazEditText.text.clear()
            binding.yasTextView.text = ""
        }

        restoreData()

        binding.yasiniyazEditText.setOnClickListener {
            binding.yasTextView.text = binding.yasiniyazEditText.text.toString()
            saveData()
        }

        binding.silButton.setOnClickListener {
            binding.yasiniyazEditText.text.clear()
            binding.yasTextView.text = ""
            clearData()
        }
    }

    private fun saveData() {
        val editor = sharedPref.edit()
        editor.putString("editTextContent", binding.yasiniyazEditText.text.toString())
        editor.putString("textViewContent", binding.yasTextView.text.toString())
        editor.apply()
    }

    private fun restoreData() {
        val savedEditTextContent = sharedPref.getString("editTextContent", "")
        val savedTextViewContent = sharedPref.getString("textViewContent", "")
        binding.yasiniyazEditText.setText(savedEditTextContent)
        binding.yasTextView.text = savedTextViewContent
    }

    private fun clearData() {
        val editor = sharedPref.edit()
        editor.remove("editTextContent")
        editor.remove("textViewContent")
        editor.apply()





    }
}

