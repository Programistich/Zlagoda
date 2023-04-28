package zlagoda.ukma.edu.ua.screens.options.ui.melnyk

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import zlagoda.ukma.edu.ua.screens.options.viewmodel.OptionsEvent

@Composable
internal fun ComposableReportMelnyk(onEvent: (OptionsEvent) -> Unit) {
    var param by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Звіти Мельник",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onEvent(OptionsEvent.MelnykGroup(param)) }
        ) {
            Text(
                "Список рейтингу продавців та категорій в якій вони робили продажі",
                textAlign = TextAlign.Center
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                modifier = Modifier.weight(4f),
                onClick = {
                    onEvent(OptionsEvent.MelnykNot)
                }) {
                Text(
                    "Категорї в яких ще не було покупок та категорії до яких входять товари з Gaming",
                    textAlign = TextAlign.Center
                )
            }
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = param,
                onValueChange = {
                    val str = it.replace(Regex("[^\\d]"), "")
                    param = if (str.isNotEmpty()) str.toString() else "0.0";
                    },
                label = { Text("Filter Selling Param:") }
            )
        }
    }
}
