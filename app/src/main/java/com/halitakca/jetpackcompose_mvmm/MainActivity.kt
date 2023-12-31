package com.halitakca.jetpackcompose_mvmm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.halitakca.jetpackcompose_mvmm.ui.theme.JetpackComposeMVMMTheme
import com.halitakca.jetpackcompose_mvmm.viewmodel.PageViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVMMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page(){
    val tf1Number = remember { mutableStateOf("") }
    val tf2Number = remember { mutableStateOf("") }
    val viewModel : PageViewModel = viewModel()
//    val result = remember { mutableStateOf("0") }
    val result = viewModel.result.observeAsState("0")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = result.value, fontSize = 50.sp)
        TextField(value = tf1Number.value, onValueChange = {tf1Number.value  = it}, label = { Text(text = "Number 1")})
        TextField(value = tf2Number.value, onValueChange = {tf2Number.value  = it}, label = { Text(text = "Number 2")})

        Button(onClick = {
            viewModel.sum(tf1Number.value,tf2Number.value)
            // Not Needed anymore: result.value = viewModel.result
        }) {
            Text(text = "SUM")
        }
        Button(onClick = {
            viewModel.multiply(tf1Number.value,tf2Number.value)
            // Not Needed anymore: result.value = viewModel.result
        }) {
            Text(text = "MULT")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeMVMMTheme {

    }
}