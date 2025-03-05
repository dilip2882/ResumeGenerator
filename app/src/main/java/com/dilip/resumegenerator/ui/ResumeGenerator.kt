package com.dilip.resumegenerator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dilip.resumegenerator.ui.components.BulletPointText
import com.dilip.resumegenerator.ui.components.ColorPickerDialog
import com.dilip.resumegenerator.ui.components.PersonalDetails
import com.dilip.resumegenerator.ui.components.TextSection

@Composable
fun ResumeGenerator(personalDetails: PersonalDetails) {
    var fontSize by remember { mutableFloatStateOf(18f) }
    val fontColor by remember { mutableStateOf(Color.Red) }
    var bgColor by remember { mutableStateOf(Color(0xFFDFFFD6)) } // Light Green

    var showFontSlider by remember { mutableStateOf(false) }
    var showColorPicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = bgColor)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = personalDetails.name,
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = fontColor
                )
                Text(text = personalDetails.email, fontSize = (fontSize - 2).sp, color = fontColor)
                Text(text = personalDetails.phone, fontSize = (fontSize - 2).sp, color = fontColor)

                Spacer(modifier = Modifier.height(12.dp))

                TextSection(title = "SKILLS", fontSize, fontColor)
                personalDetails.skills.forEach { skill ->
                    BulletPointText(skill, fontSize, fontColor)
                }

                Spacer(modifier = Modifier.height(12.dp))

                TextSection(title = "PROJECTS", fontSize, fontColor)
                personalDetails.projects.forEach { project ->
                    BulletPointText(project, fontSize, fontColor)
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        if (showFontSlider) {
            Column {
                Text(text = "Font Size: ${fontSize.toInt()}", color = Color.White)
                Slider(
                    value = fontSize,
                    onValueChange = { fontSize = it },
                    valueRange = 12f..24f
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { showFontSlider = !showFontSlider }) {
                Text("Font Size")
            }
            Button(onClick = { showColorPicker = true }) {
                Text("Bg Color")
            }
        }

        if (showColorPicker) {
            ColorPickerDialog(onDismiss = { showColorPicker = false }) {
                bgColor = it
            }
        }
    }
}

