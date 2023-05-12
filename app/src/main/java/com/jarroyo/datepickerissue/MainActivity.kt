package com.jarroyo.datepickerissue

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.jarroyo.datepickerissue.ui.theme.AppTheme
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DatePicker()
                }
            }
        }
    }

    @Composable
    private fun DatePicker(){
        val activity = LocalContext.current as AppCompatActivity
        MaterialDatePicker.Builder.datePicker().apply {
            setTitleText("title")
            setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
        }.build().run {
            show(activity.supportFragmentManager, "fragmentTag")
        }
    }
}
