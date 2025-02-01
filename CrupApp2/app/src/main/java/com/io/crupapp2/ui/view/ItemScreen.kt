package com.io.crupapp2.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.io.crupapp2.model.Item
import com.io.crupapp2.ui.viewModel.ItemViewModel


@Composable
fun ItemScreen(
    modifier: Modifier = Modifier, viewModel: ItemViewModel = viewModel()
) {
    val items by viewModel.items

    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedItems by remember { mutableStateOf<Item?>(null) }


    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )



        Button(
            onClick = {
                viewModel.addItem(Item(title = title.text, description = description.text))
                title = TextFieldValue("")
                description = TextFieldValue("")
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Adicionar")
        }


        LazyColumn {
            items(items.size) { index ->
                val item = items[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        Modifier.padding(8.dp)
                    ) {
                        Text("Título: ${item.title}")
                        Text("Título: ${item.title}")
                        Spacer(modifier = Modifier.height(8.dp))

                        Row {
                            Button(onClick = { viewModel.deleteItem(item.id) }) {
                                Text(text = "Deletar")
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(onClick = {
                                selectedItems = item
                                showDialog = true
                            }) {
                                Text("Atualizar")
                            }
                        }

                    }
                }
            }

        }
    }
    if (showDialog){
        UpdateItemDialog(
            item = selectedItems,
            onDimiss = {showDialog = false},
            onUpdate = { updateItem ->
            viewModel.updateItem(updateItem)
            showDialog = false
        })
    }

}

@Composable
fun UpdateItemDialog(item: Item?, onDimiss: () -> Unit, onUpdate: (Item) -> Unit) {

    if (item == null) return

    var title by remember { mutableStateOf(TextFieldValue(item.title)) }
    var description by remember { mutableStateOf(TextFieldValue(item.description)) }

    AlertDialog(
        onDismissRequest = onDimiss,
        title = { Text("Editar item") },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onUpdate(item.copy(title = title.text, description = description.text))
            }) {
                Text("Salvar")
            }
        },
        dismissButton = {
            Button(onClick = onDimiss) {
                Text("Cancelar")
            }
        }
    )


}