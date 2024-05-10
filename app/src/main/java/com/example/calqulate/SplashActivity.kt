package com.example.calqulate

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.calqulate.ui.theme.CalQulateTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalQulateTheme {
                SplashScreen(this)
            }
        }
    }
}
@Composable
fun SplashScreen(context: Context) {
    val handler = Handler()
    handler.postDelayed({
        val intent = Intent(context, MainActivity::class.java)
        startActivity(context, intent, null)
    }, 3000)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
        ) {
        TitleText()
    }
}

@Composable
fun TitleText() {
    Text(
        text = "CalQulate",
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalQulateTheme {
    }
}