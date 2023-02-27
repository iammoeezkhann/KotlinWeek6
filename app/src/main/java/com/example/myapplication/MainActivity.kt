package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldApp()
                    MyTopBar()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldApp(){
    Scaffold(
        topBar = { TopAppBar{ Text(text = "My app")}},
        content = { Text(text = "Content for home screen")},
      //  bottomBar = { BottomAppBar { Text(text = "Bottom bar")}}
    ) 
}

@Composable
fun MyTopBar(){
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(title = { Text(text = "My app")},
    navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Menu, contentDescription = null)
        
    }},
    actions = {
        IconButton(onClick = { expanded=!expanded }) {
            Icon(Icons.Filled.MoreVert, contentDescription = null)
            
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded= false}) {
            DropdownMenuItem(onClick = { /*TODO*/ }) {
                Text("Settings")
                
            }
            DropdownMenuItem(onClick = { /*TODO*/ }) {
                Text( "Info")
                
            }


        }
    })


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ScaffoldApp()
        MyTopBar()
    }
}