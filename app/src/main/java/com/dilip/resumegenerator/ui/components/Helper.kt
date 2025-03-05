package com.dilip.resumegenerator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

data class PersonalDetails(
    val name: String,
    val email: String,
    val phone: String,
    val skills: List<String>,
    val projects: List<String>
)

@Composable
fun TextSection(title: String, fontSize: Float, color: Color) {
    Column {
        Text(text = title, fontSize = fontSize.sp, color = color, fontWeight = FontWeight.Bold)
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 4.dp),
            thickness = 1.dp,
            color = color
        )
    }
}

@Composable
fun BulletPointText(text: String, fontSize: Float, color: Color) {
    Text(text = "• $text", fontSize = fontSize.sp, color = color)
}

@Composable
fun ColorPickerDialog(onDismiss: () -> Unit, onColorSelected: (Color) -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray, RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Text("Pick a Color", color = Color.White)

            val controller = rememberColorPickerController()

            HsvColorPicker(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                controller = controller,
                onColorChanged = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onDismiss) {
                    Text("Cancel")
                }
                Button(onClick = {
                    onColorSelected(controller.selectedColor.value)
                    onDismiss()
                }) {
                    Text("Select")
                }
            }
        }
    }
}
