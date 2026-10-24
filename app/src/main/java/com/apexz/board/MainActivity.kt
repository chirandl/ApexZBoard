package com.apexz.board

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContent { ApexHome() } }
    @Composable private fun ApexHome() {
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val enabled = manager.enabledInputMethodList.any { it.packageName == packageName }
        MaterialTheme(colorScheme = lightColorScheme(primary = Color(0xFF2998E8), background = Color(0xFFF7FBFF))) {
            Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF7FBFF)) { Column(Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("ApexZBoard", style = MaterialTheme.typography.headlineLarge, color = Color(0xFF17324D)); Text("Sinhala • Singlish • English", color = Color(0xFF69839A))
                Card { Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) { Text(if (enabled) "Keyboard enabled" else "Keyboard setup required"); Text("Android requires you to authorize and select keyboards manually.")
                    Button(onClick = { startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)) }) { Text("Enable Keyboard") }
                    Button(onClick = { manager.showInputMethodPicker() }, enabled = enabled) { Text("Select Keyboard") }
                } }
                OutlinedButton(onClick = { startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)) }) { Text("Reconfigure Keyboard") }
                Text("Core typing is offline. ApexZBoard does not request internet access or collect typed text.", color = Color(0xFF69839A))
            } }
        }
    }
}
